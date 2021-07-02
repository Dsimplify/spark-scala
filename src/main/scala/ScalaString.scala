object ScalaString {
    def main(args: Array[String]): Unit = {
        val name = "scala"
        val subname = name.substring(0,2)
       // println(subname)

        // 字符串的连接
        val s = name + subname
       // println(s)
       // println("hello " + name)

        // 传值字符串
        //printf("name=%s\n", name)

        // 多行字符串
        println(
            s"""
               |hello
               |${name}
               |""".stripMargin)
    }
}
