package com.df.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming01_WordCount {
    def main(args: Array[String]): Unit = {

        // 创建spark环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        // 读取数据
        val socketDS: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

        // 执行逻辑
        socketDS.flatMap(line => {
            val data: Array[String] = line.split(" ")
            data
        }).map((_, 1)).groupByKey().map(a => (a._1, a._2.size)).print()


        // 启动采集器
        ssc.start()

        // 等待采集器的结束
        ssc.awaitTermination()

    }
}
