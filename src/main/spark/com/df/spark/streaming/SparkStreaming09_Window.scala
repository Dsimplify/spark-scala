package com.df.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming09_Window {
    def main(args: Array[String]): Unit = {

        // 创建连接环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        ssc.sparkContext.setCheckpointDir("cp")

        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)
        val wordToOneDS: DStream[(String, Int)] = ds
          .flatMap(a => a.split(" "))
          .map((_, 1))

        // 将多个采集周期作为整体计算
        // 窗口的周期是采集周期的整数倍
        // 默认滑动的幅度（步长）为一个采集周期
        // 窗口的计算周期等同于窗口的滑动的步长
        // 窗口的范围大小和滑动的步长应该都是采集周期的整数倍
        val result: DStream[(String, Int)] = wordToOneDS.window(Seconds(9), Seconds(6))
          .reduceByKey(_ + _)

        result.print()



        ssc.start()
        ssc.awaitTermination()
    }
}
