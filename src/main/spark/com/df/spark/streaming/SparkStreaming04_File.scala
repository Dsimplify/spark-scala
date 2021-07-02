package com.df.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming04_File {
    def main(args: Array[String]): Unit = {

        //创建执行环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")

        val ssc = new StreamingContext(sparkConf,Seconds(3))

        val dirDS: DStream[String] = ssc.textFileStream("input/user.json")
        dirDS.print()

        ssc.start()
        ssc.awaitTermination()
    }
}
