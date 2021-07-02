package com.df.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object SparkSQL02_Test1 {
    def main(args: Array[String]): Unit = {

        // 1.创建执行环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")
        val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        // 导入隐式转换
        import spark.implicits._


        // 2.读取数据
        val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List(
            (1, "zhangsan", 30),
            (2, "lisi", 20),
            (3, "wangwu", 40)
        ))

        val df: DataFrame = rdd.toDF("id", "name", "age")

        df.createOrReplaceTempView("user")
//        val ds: Dataset[User] = df.map(row => {
//            val id: Int = row(0)
//            val name = row(1)
//            val age = row(2)
//            User(id, "name: " + name, age)
//        })

        val userRDD: RDD[User] = rdd.map {
            case (id, name, age) => {
                User(id, name, age)
            }
        }
        val ds: Dataset[User] = userRDD.toDS()
        val newDS: RDD[User] = userRDD.map(user => {
            User(user.id, "name: " + user.name, user.age)
        })
//
//        newDS.show

        ds.show()



        spark.udf.register("addName", (x: String) => "Name:"+x)
        spark.udf.register("changeAge", (x: Int) => x)

        spark.sql("select addName(name), changeAge(age) from user").show()


        // 3.释放资源
        spark.stop()
    }
    case class User(id:Int, name:String, age:Int)
}
