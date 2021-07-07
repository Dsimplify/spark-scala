package com.df.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Item {
    def main(args: Array[String]): Unit = {
        // spark环境
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("item")
        // 连接
        val sc = new SparkContext(sparkConf)

        val rdd1: RDD[(String, String, Double)] = sc.textFile("E:\\workspace\\spark-scala\\input\\test.txt")
          .map(a => {
              val datas: Array[String] = a.split(" ")
              (datas(0), datas(1), datas(2).toDouble)
          })
        // println(rdd1.collect().mkString(","))

        // 提取用户id 和 商品id
        val rdd2: RDD[(String, String)] = rdd1.map(f => (f._1, f._2))

        // 获取用户购买商品的笛卡儿积
        val rdd3: RDD[(String, (String, String))] = rdd2.join(rdd2)

        //println(rdd3.collect().mkString(" "))

        // 对每一个（item_i, item_j）进行wordcount
        val rdd4: RDD[((String, String), Int)] = rdd3.map(f => (f._2, 1))
                                                     .reduceByKey(_ + _)
        // 获取物品i的出现次数
        val rdd5: RDD[((String, String), Int)] = rdd4.filter(f => f._1._1 == f._1._2)

        // 获取同时购买了物品i和物品j的用户数
        // 注意因为join的原因，[i,j]和[j,i] 其实是一个值，
        // 这里的用户数为实际用户数*2。
        val rdd6: RDD[((String, String), Int)] = rdd4.filter(f => f._1._1 != f._1._2)

        // 获取物品i的购买次数 (i, count)
        val rdd7: RDD[(String, Int)] = rdd5.map(f => (f._1._1, f._2))

        // (i, （i, j, cij）)
        val rdd8: RDD[(String, (String, String, Int))] = rdd6.map(f => (f._1._1, (f._1._1, f._1._2, f._2)))
        // (i,(i, j, cij),i)
        val rdd9: RDD[(String, ((String, String, Int), Int))] = rdd8.join(rdd7)

        // 获取物品j的购买次数
        val rdd10: RDD[(String, (String, String, Int, Int))] = rdd9.map(f => (f._2._1._2, (f._2._1._1, f._2._1._2, f._2._1._3, f._2._2)))
        val rdd11: RDD[(String, ((String, String, Int, Int), Int))] = rdd10.join(rdd7)

        val rdd12: RDD[(String, String, Int, Int, Int)] = rdd11.map(f => (f._2._1._1, f._2._1._2, f._2._1._3, f._2._1._4, f._2._2))

        val rdd13: RDD[(String, String, Double)] = rdd12.map(f => (f._1, f._2, f._3 / scala.math.sqrt(f._4 * f._5)))

        rdd13.foreach(println)
    }
}
