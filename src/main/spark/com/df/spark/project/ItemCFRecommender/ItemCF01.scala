package com.df.spark.project.ItemCFRecommender

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ItemCF01 {
    def main(args: Array[String]): Unit = {
        val RATING_DATA_PATH: String = args(0) // 数据加载路径
        val RESULT_PATH: String = args(1) // 结果存放路径

        // 配置spark环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("item01")
        val sc = new SparkContext(sparkConf)

        // 加载数据
        val originRDD: RDD[String] = sc.textFile(RATING_DATA_PATH)

        //
        val ratingRDD: RDD[(Int, Int, Double)] = originRDD.map(d => {
            val datas: Array[String] = d.split(",")
            (datas(0).toInt, datas(1).toInt, datas(2).toDouble)
        }).cache()

        // 提取用户id 和 商品id
        val userAndProduct: RDD[(Int, Int)] = ratingRDD.map(d => (d._1, d._2))

        // 获取用户和商品的笛卡尔积
        val ppRDD: RDD[((Int, Int), Int)] = userAndProduct.join(userAndProduct)
          .map(d => ((d._2._1, d._2._2), 1))
          .reduceByKey(_ + _)

        // 评价了 i/j 的用户数 ((i, j), iCount)
        val Count: RDD[((Int, Int), Int)] = ppRDD.filter(d => d._1._1 == d._1._2)
        val ic: RDD[(Int, Int)] = Count.map(d => (d._1._1, d._2))
        val jc: RDD[(Int, Int)] = Count.map(d => (d._1._2, d._2))

        // 评价了 i 和 j 的用户数  ((i, j), ijCount)
        val ijCount: RDD[((Int, Int), Int)] = ppRDD.filter(d => d._1._1 != d._1._2)

        ijCount.map(d => (d._1._1, (d._1._1, d._1._2, d._2))) // (i, (i, j, ijCount))
          .join(ic) // (i,((i, j, ijCount), iCount))
          .map(d => (d._2._1._2, (d._2._1._1, d._2._1._2, d._2._1._3, d._2._2))) // (j, (i, j, ijCount, iCount))
          .join(jc) // (j, ((i, j, ijCount, iCount), jCount))
          .map{d => (d._2._1._1, (d._2._1._2, d._2._1._3 / math.sqrt(d._2._2 * d._2._1._4)))} // (i, j, a)
          .groupByKey()
          .map{
              case (k, v) =>
                  (k, v.toList
                      .filter(d => k != d._1)
                      .sortWith(_._2 > _._2)
                      .take(10)
                      .map(x => (x._1, x._2)))
          }  // (Int, List[(Int, Double)])
          .map(d => {
              d._2.map(a => {
                  val s = d._1 + "|" + a._1
                  s
              })
          })
          .flatMap(list => list)
          //.coalesce(1)
          .saveAsTextFile(RESULT_PATH)

        sc.stop()
    }
}
