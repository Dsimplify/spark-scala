package com.df.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkSQL05_LoadSava {
    def main(args: Array[String]): Unit = {

        //  创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")

        val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        // 导入隐式转换
        import spark.implicits._
        //val df: DataFrame = spark.read.format("json").load("input/user.json")

        //df.write.mode("append").format("json").save("output")

        spark.sql("select * from json.`input/user.json`").show

        // 释放资源
        spark.stop()
    }
}
