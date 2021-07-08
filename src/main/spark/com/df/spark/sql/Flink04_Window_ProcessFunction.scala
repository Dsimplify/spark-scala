package com.df.spark.sql

import com.df.spark.sql.SparkSQL03_UDAF.MyAvgAgeUDAF
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{DataFrame, Dataset, Encoder, Encoders, SparkSession}

object Flink04_Window_ProcessFunction {
    def main(args: Array[String]): Unit = {

        // 1.创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")

        // build 构建、创建
        val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        //导入隐式转换
        import spark.implicits._

        val rdd: RDD[(Int, String, Long)] = spark.sparkContext.makeRDD(List(
            (1, "zhangsan", 30L),
            (2, "lisi", 20L),
            (3, "wangwu", 40L)
        ))

        val df: DataFrame = rdd.toDF("id", "name", "age")
        val ds: Dataset[User] = df.as[User]

        val udaf = new MyAvgAgeUDAFClass

        ds.select(udaf.toColumn).show()

        spark.stop()

    }

    case class User(id: Int, name: String, age: Long)
    case class AvgBuffer(var totalage: Long, var count: Long)

    class MyAvgAgeUDAFClass extends Aggregator[User, AvgBuffer, Long] {

        // 缓冲区的初始值
        override def zero: AvgBuffer = {
            AvgBuffer(0L, 0L)
        }

        // 聚合数据
        override def reduce(b: AvgBuffer, a: User): AvgBuffer = {
            b.totalage = b.totalage + a.age
            b.count = b.count + 1
            b
        }

        // 合并缓冲区
        override def merge(b1: AvgBuffer, b2: AvgBuffer): AvgBuffer = {
            b1.totalage = b1.totalage + b2.totalage
            b1.count = b1.count + b2.count
            b1
        }

        override def finish(reduction: AvgBuffer): Long = {
            reduction.totalage / reduction.count
        }

        override def bufferEncoder: Encoder[AvgBuffer] = Encoders.product

        override def outputEncoder: Encoder[Long] =  Encoders.scalaLong
    }
}
