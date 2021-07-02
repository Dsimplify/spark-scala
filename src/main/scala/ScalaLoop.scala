object ScalaLoop {
    def main(args: Array[String]): Unit = {
//        for (i <- 1 to 9) {
//            val n = 2 * i - 1
//            val m = 9 - i
//                println(" " * m + "*" * n)
//        }

        val result = for (i <- Range(1, 5)) yield {
            i * 2
        }
        println(result)
    }
}
