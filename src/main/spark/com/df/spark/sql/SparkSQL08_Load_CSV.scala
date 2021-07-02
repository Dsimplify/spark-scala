package com.df.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkSQL08_Load_CSV {
    def main(args: Array[String]): Unit = {

        // 创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")

        // 创建sparksession对象
        val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        // 导入隐式转换，spark为环境变量名称
        import spark.implicits._

        val df: DataFrame = spark.read
          .format("csv")
          //.option("sep", ";")
          .option("inferSchema", "true")
          .option("header", "true")
          .load("input/user_visit_action.csv")

        df.show()

        //释放资源
        spark.stop()
    }
}
