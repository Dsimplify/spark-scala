package com.df.spark.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object SparkSQL01_Test {
    def main(args: Array[String]): Unit = {

        // 1.创建执行环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()

        // 导入隐式转换
        import spark.implicits._

        // 2.读取数据
        val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List(
            (1, "zhangsan", 30),
            (2, "lisi", 20),
            (3, "wangwu", 40)
        ))

        val df = rdd.toDF("id", "name", "age")

        //df.show()
        //将df转换为临时视图
        df.createOrReplaceTempView("user")
        //spark.sql("select * from user").show

        df.select("name", "age").show
        df.select($"name", $"age").show
        df.select('name, 'age).show

//        val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List(
//            (1, "d", 20),
//            (2, "f", 21),
//            (3, "w", 22)
//        ))
//
//        val df: DataFrame = rdd.toDF("id", "name", "age")
//        //df.show()
//
//        val dfToRDD: RDD[Row] = df.rdd
//       // println(rdd.collect().mkString(","))
//
//        val userRDD: RDD[User] = rdd.map {
//            case (id, name, age) => User(id, name, age)
//        }
//
//        df.as[User].show()
//        userRDD.toDS().show()

        // 3.释放对象
        spark.stop()
    }
    case class User(id:Int, name:String, age:Int)
}
