package com.df.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object SparkStreaming03_Queue {
    def main(args: Array[String]): Unit = {

        //创建执行环境
        val sparkconf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streamig")

        val ssc = new StreamingContext(sparkconf, Seconds(3))

        val queue = new mutable.Queue[RDD[String]]()
        val queueDS: InputDStream[String] = ssc.queueStream(queue)

        queueDS.print()
        ssc.start()

        for (i <- 1 to 7) {
            val rdd: RDD[String] = ssc.sparkContext.makeRDD(List(i.toString))
            queue.enqueue(rdd)
            Thread.sleep(1000)
        }

        ssc.awaitTermination()
    }
}
