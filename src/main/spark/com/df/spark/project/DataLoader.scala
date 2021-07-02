package com.df.spark.project

import java.io.File

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}



object DataLoader {
    // 定义数据文件路径
    val PRODUCT_DATA_PATH = "E:\\workspace\\spark-scala\\input\\products.csv"
    val RATING_DATA_PATH = "E:\\workspace\\spark-scala\\input\\ratings.csv"
    val RESULT_PATH = "E:\\workspace\\spark-scala\\output\\result"

    def main(args: Array[String]): Unit = {
        // 创建spark环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("DataLoader")
        // 创建连接
        val sc = new SparkContext(sparkConf)

        // 加载数据
        val productRDD = sc.textFile(PRODUCT_DATA_PATH)
        val product = productRDD.map(
            item => {
                val data: Array[String] = item.split("\\^")
                val product = data(0).toInt + "|" + data(1).trim + "|" +
                              data(4).trim + "|" + data(5).trim + "|" + data(6).trim
                product
            }
        )

        val ratingRDD = sc.textFile(RATING_DATA_PATH)
        val rating: RDD[String] = ratingRDD.map(item => {
            val data: Array[String] = item.split(",")
            val rating = data(0).toInt + "|" + data(1).toInt + "|" +
              data(2).toDouble + "|" + data(3).toInt
            rating
        })

        // 判断路径是否存在
        val path = new File(RESULT_PATH)
        dirDel(path)

        /**
         * 判断路径是否存在，存在的话就删除
         * @param path
         */
        def dirDel(path: File): Unit = {
            val files: Array[File] = path.listFiles()
            files.foreach(f => {
                if (f.isDirectory){
                    dirDel(f)
                } else {
                    f.delete()
                    println("delete file" + f.getAbsolutePath)
                }
            })
            path.delete()
            println("delete path" + path.getAbsolutePath)
        }

        rating.saveAsTextFile("E:\\workspace\\spark-scala\\output\\result\\1.txt")
        product.saveAsTextFile("E:\\workspace\\spark-scala\\output\\result\\2.txt")

    }
}

///**
// * Product数据集
// *
// * @param productId 商品id
// * @param name 商品名称
// * @param imageUrl 商品图片的URL
// * @param categories 商品分类
// * @param tags 商品UGC标签
// */
//case class Product(productId: Int,
//                   name: String,
//                   imageUrl: String,
//                   categories: String,
//                   tags: String)
//
///**
// * Rating数据集
// *
// * @param userId 用户id
// * @param productId 商品id
// * @param score 评分
// * @param timestamp 时间戳
// */
//case class Rating(userId: Int,
//                  productId: Int,
//                  score: Double,
//                  timestamp: Int)
