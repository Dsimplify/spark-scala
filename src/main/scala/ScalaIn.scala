object ScalaIn {
    def main(args: Array[String]): Unit = {

        // 标准化屏幕输入
        val age: Int = scala.io.StdIn.readInt()
        //println(age)

        scala.io.Source.fromFile("input/user.json").foreach(
            line => {
                print(line)
            }
        )
//        scala.io.Source.fromFile("input/user.json").getLines().foreach(println)
    }
}
