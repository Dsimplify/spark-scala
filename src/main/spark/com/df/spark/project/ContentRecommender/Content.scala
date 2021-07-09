package com.df.spark.project.ContentRecommender

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}


case class Product(productId: Int, name: String, imageUrl:String, categories: String, tags: String)

// 定义标准推荐对象
case class Recommendation(productId: Int, score: Double)

// 定义商品相似度列表
case class ProductRecs(productId: Int, recs: Seq[Recommendation])

object Content {
    // 定义数据加载路径
    val PRODUCT_DATA_PATH = null
    val CONTENT_PRODUCT_RECS = null

    def main(args: Array[String]): Unit = {
        // 创建spark config
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Content")
        // 创建sparksession
        val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        import spark.implicits._

        // 加载数据
        val productRDD: RDD[String] = spark.sparkContext.textFile("E:\\workspace\\spark-scala\\input\\products.csv")

        // 数据处理
        val productTagsDF: DataFrame = productRDD.map(d => {
            val datas: Array[String] = d.split("\\^")
            (datas(0).toInt, datas(1).toString, datas(5).toString)
        })
          .toDF("productId", "name", "tags")
          .cache()
        productTagsDF.rdd.foreach(println)



    }
}
