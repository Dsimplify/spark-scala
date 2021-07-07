package com.df.spark.project

import java.io.File

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}


/**
 * Product数据集
 *
 * @param productId 商品id
 * @param name 商品名称
 * @param imageUrl 商品图片的URL
 * @param categories 商品分类
 * @param tags 商品UGC标签
 */
case class Product(productId: Int, name: String, imageUrl: String, categories: String, tags: String)

/**
 * Rating数据集
 *
 * @param userId 用户id
 * @param productId 商品id
 * @param score 评分
 * @param timestamp 时间戳
 */
case class Rating(userId: Int, productId: Int, score: Double, timestamp: Int)


// 定义标准推荐对象
case class Recommendation( productId: Int, score: Double )

// 定义商品相似度列表
case class ProductRecs( productId: Int, recs: Seq[Recommendation] )

object ItemCF {

    // 定义数据文件路径
    val PRODUCT_DATA_PATH = "E:\\workspace\\spark-scala\\input\\products.csv"
    val RATING_DATA_PATH = "E:\\workspace\\spark-scala\\input\\ratings.csv"
    val RESULT_PATH = "E:\\workspace\\spark-scala\\output\\result"

    def main(args: Array[String]): Unit = {
        // 创建spark环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("ItemCF")
        // 创建连接
        val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        import spark.implicits._

        // 加载数据
        val ratingRDD = spark.sparkContext.textFile(RATING_DATA_PATH)
        // 转换为DF
        val ratingDF: DataFrame = ratingRDD.map(item => {
            val data: Array[String] = item.split(",")
            (data(0).toInt, data(1).toInt, data(2).toDouble)
        })
          .toDF("userId", "productId", "score")
          .cache()


        // 计算同现相似度，得到商品的相似列表
        // 统计每个商品的评分个数
        val productRatingCountDF: DataFrame = ratingDF.groupBy("productId").count()
        // 在原有评分表上rating添加count
        val ratingWithCountDF: DataFrame = ratingDF.join(productRatingCountDF,"productId")

        // 将评分按照用户ID两两匹配，统计两个商品被同一个用户评分过的次数
        val joinedDF: DataFrame = ratingWithCountDF.join(ratingWithCountDF, "userId")
          .toDF("userId", "product1", "score1", "count1", "product2", "score2", "count2")
          .select("userId", "product1", "count1", "product2", "count2")
        // 创建一张临时表，用于写SQL查询
        joinedDF.createOrReplaceTempView("joined")

        // 按照product1,product2 做group by，统计userId的数量，就是对两个商品同时评分的人数
        val cooccurrenceDF: DataFrame = spark.sql(
            """
              |select product1
              |, product2
              |, count(userId) as cocount
              |, first(count1) as count1
              |, first(count2) as count2
              |from joined
              |group by product1, product2
            """.stripMargin
        ).cache()

        val value: RDD[ProductRecs] = cooccurrenceDF.map { row =>
                val coocSim = cooccurrenceSim(row.getAs[Long]("cocount"),
                    row.getAs[Long]("count1"), row.getAs[Long]("count2"))
                (row.getInt(0), (row.getInt(1), coocSim))

        }
          .rdd
          .groupByKey()
          .map {
              case (productId, recs) =>
                  ProductRecs(productId, recs.toList
                    .filter(x => x._1 != productId)
                    .sortWith(_._2 > _._2)
                    .take(10)
                    .map(x => Recommendation(x._1, x._2)))
          }


        // 判断路径是否存在
        val path = new File(RESULT_PATH)
        dirDel(path)

        // 保存数据
        value.map(r => {
            r.recs.map(a => {
                val s = r.productId + "|" + a.productId
                s
            })
        })
          .flatMap(list => list)
          .coalesce(1)
          .saveAsTextFile("E:\\workspace\\spark-scala\\output\\result\\2.txt")

        spark.stop()
    }

    // 按照公式计算同现相似度
    def cooccurrenceSim(coCount: Long, count1: Long, count2: Long): Double ={
        coCount / math.sqrt( count1 * count2 )
    }

    /**
     * 判断路径是否存在，存在的话就删除
     * @param path
     */
    def dirDel(path: File): Unit = {
        if (path.exists()) { // 判断文件夹是否存在，不存在就不做处理
            val files: Array[File] = path.listFiles()
            files.foreach(f => { // 递归删除文件夹里的子目录和文件
                if (f.isDirectory){
                    dirDel(f)
                } else {
                    f.delete()
                    println("delete file" + f.getAbsolutePath)
                }
            })
            // 删除主路径
            path.delete()
            println("delete path" + path.getAbsolutePath)
        }
    }
}

