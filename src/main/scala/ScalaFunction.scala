object ScalaFunction {
    def main(args: Array[String]): Unit = {

//        def fun1() = {
//            println("函数体")
//        }
//        fun1()

//        def fun3( name:String ): Unit = {
//            println( name )
//        }
//        fun3("zhangsan")

//
//            def fun4(name:String): String = {
//                "Hello " + name
//            }
//            println( fun4("zhangsan") )

//            def fun7(names:String*): Unit = {
//                println(names)
//            }
//            fun7()
//            fun7( "zhangsan" )
//            fun7( "zhangsan", "lisi" )

//        def fun5() = {
//           return  "zhangsan" (x)
//        }
//        println(fun5())

//        def fun1(): String = {
//            "zhangsan"
//        }
//        val a = fun1
//        val b = fun1 _
//        println(a)
//        println(b)

//         def f4(f:Int => Int) = {
//             f(10)
//         }
//       // (x:Int) => {x * 2}
//        println(f4((x:Int) => {x * 2}))

        def fun9(): String = {
            println("function...")
            "zhangsan"
        }
        lazy val a = fun9()
        println("----------")
        println(a)

    }
}
