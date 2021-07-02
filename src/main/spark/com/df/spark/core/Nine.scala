package com.df.spark.core

object Nine {
    def main(args: Array[String]): Unit = {

        for (i <- 1 to 9) {
            val m = 2 * i - 1
            val n = 9 - i
            println(" " * n + "*" * m)
        }


    }
}
