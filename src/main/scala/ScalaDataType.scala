object ScalaDataType {
    def main(args: Array[String]): Unit = {
        val c = 'A' + 1
        //println(c)

        val i = 10
        val s = "hello " + i
       // println(s)


        val a = new String("abc")
        val b = new String("abc")

        println(a == b) // 比较值
        println(a.equals(b)) // 比较值
        println(a eq b) // 比较对象的引用
    }
}
