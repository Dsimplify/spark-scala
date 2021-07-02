package com.df.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming10_Window1 {
    def main(args: Array[String]): Unit = {

        // 创建执行环境
        val s: SparkConf = new SparkConf().setMaster("local[*]").setAppName("s")
        val ssc = new StreamingContext(s,Seconds(3))

        ssc.sparkContext.setCheckpointDir("cp1")

        // 读取数据
        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)
        val wordToOneDS: DStream[(String, Int)] = ds.map(a => ("key", a.toInt))


        val result: DStream[(String, Int)] = wordToOneDS.reduceByKeyAndWindow(
            (x, y) => {
                println(s"x = ${x}, y = ${y}")
                x + y
            },
            (a, b) => {
                println(s"a = ${a}, b = ${b}")
                a - b
            },
            Seconds(9)
        )

        result.print()



        // 开始执行
        ssc.start()

        // 等待执行结束
        ssc.awaitTermination()
    }
}
