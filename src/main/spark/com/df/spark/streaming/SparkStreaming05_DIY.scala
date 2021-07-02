package com.df.spark.streaming

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming05_DIY {
    def main(args: Array[String]): Unit = {

        // 创建执行环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        // 执行逻辑
        val ds: ReceiverInputDStream[String] = ssc.receiverStream(new MyReceiver("localhost", 9999))

        ds.print()

        ssc.start()

        ssc.awaitTermination()
    }

    // TODO 自定义数据采集器
    // 1. 继承Receiver，定义泛型。
    //    Receiver的构造方法有参数的，所以子类在继承时，应该传递这个参数
    // 2. 重写方法
    //   onStart
    //   onStop
    class MyReceiver(host: String, port: Int) extends Receiver[String](StorageLevel.MEMORY_ONLY) {

        private var socket: Socket = _

        def receive(): Unit = {
            val reader = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream,
                    "UTF-8"
                )
            )

            var s: String = null

            while (true) {
                s = reader.readLine()
                if (s != null) {
                    store(s)
                }
            }
        }

        override def onStart(): Unit = {
            socket = new Socket(host, port)
            new Thread("Socket Receiver") {
                setDaemon(true)  // true表示为守护线程
                override def run() { receive()}
            }.start()
        }

        override def onStop(): Unit = {
            socket.close()
            //socket = null
        }
    }
}
