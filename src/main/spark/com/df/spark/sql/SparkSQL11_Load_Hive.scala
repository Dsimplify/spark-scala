package com.df.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkSQL11_Load_Hive {
    def main(args: Array[String]): Unit = {
        // TODO 创建环境对象
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
        // builder 构建，创建

        // TODO 访问外置的Hive
        val spark = SparkSession.builder()
          .enableHiveSupport()
          .config(sparkConf).getOrCreate()
        // 导入隐式转换，这里的spark其实是环境对象的名称

        spark.sql("show databases").show


        spark.stop
    }
}
