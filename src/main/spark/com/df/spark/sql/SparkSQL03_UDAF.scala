package com.df.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object SparkSQL03_UDAF {
    def main(args: Array[String]): Unit = {

        // 1.创建执行环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sql")
        val ss: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        // 导入隐式转换
        import ss.implicits._

        // 2.读取数据
        val rdd: RDD[(Int, String, Long)] = ss.sparkContext.makeRDD(List(
            (1, "zhangsan", 30L),
            (2, "lisi", 20L),
            (3, "wangwu", 40L)
        ))

        val df: DataFrame = rdd.toDF("id", "name", "age")
        df.createOrReplaceTempView("user")

        // 创建UDAF函数
        val udaf = new MyAvgAgeUDAF

        ss.udf.register("avgAge", udaf)
        ss.sql("select avgAge(age) from user").show()

        //rdd.toDS().show()

        // 3.释放资源
        ss.stop()
    }

    class MyAvgAgeUDAF extends UserDefinedAggregateFunction {

        // 输入参数类型（结构）
        override def inputSchema: StructType = {
            StructType(Array(StructField("age", LongType)))
        }

        // 缓冲区的数据结构
        override def bufferSchema: StructType = {
            StructType(Array(
                StructField("totalage", LongType),
                StructField("count", LongType)
            ))
        }

        // 聚合函数返回的结果类型
        override def dataType: DataType = LongType

        // 函数的稳定性
        override def deterministic: Boolean = true


        // 函数缓存区初始化
        override def initialize(buffer: MutableAggregationBuffer): Unit = {
            buffer(0) = 0L
            buffer(1) = 0L
        }

        // 更新缓冲区数据
        override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
            buffer(0) = buffer.getLong(0) + input.getLong(0)

            //println(buffer.getLong(0))
            //println(input.getLong(0))

            buffer(1) = buffer.getLong(1) + 1

            //println(buffer.getLong(1))
        }

        // 合并缓冲区
        override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
            buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)

            //println(buffer1(0))

            buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)

            //println(buffer1(1))
        }

        // 函数的计算
        override def evaluate(buffer: Row): Any = {
            buffer.getLong(0) / buffer.getLong(1)
        }
    }
}
