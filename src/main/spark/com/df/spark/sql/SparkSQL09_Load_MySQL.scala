package com.df.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkSQL09_Load_MySQL {
    def main(args: Array[String]): Unit = {

        // 创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")

        //创建sparksession对象
        val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        //导入隐式转换
        import spark.implicits._

        spark.read.format("jdbc")
          .option("url", "jdbc:mysql://localhost:3306/my_test")
          .option("diver", "com.mysql.jdbc.Driver")
          .option("user", "root")
          .option("password", "123456")
          .option("dbtable", "test1")
          .load().show()

        //释放资源
        spark.stop()
    }
}
