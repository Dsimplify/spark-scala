package com.df.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.sql.catalyst.expressions.Second
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming02_WordCount1 {
    def main(args: Array[String]): Unit = {

        // 创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        // 读取数据
        val socketDS: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

        // 处理逻辑
        socketDS.flatMap(a => a.split(" "))
            .map(a => (a, 1))
            .reduceByKey((a, b) => a + b )
            .print()

        //启动采集器
        ssc.start()
        //等待采集器结束
        ssc.awaitTermination()
    }
}
