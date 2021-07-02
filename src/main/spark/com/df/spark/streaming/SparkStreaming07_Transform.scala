package com.df.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming07_Transform {
    def main(args: Array[String]): Unit = {

        // 创建执行环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        // 执行逻辑
        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)
        ds.transform(
            rdd => {
                rdd.map(
                    data => data * 2
                )
            }
        ).print()

        ds.map(
            data => data * 2
        ).print()

        ssc.start()
        ssc.awaitTermination()
    }
}
