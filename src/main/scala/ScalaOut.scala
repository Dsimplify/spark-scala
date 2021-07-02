import java.io.{File, PrintWriter}

object ScalaOut {
    def main(args: Array[String]): Unit = {
        val writer = new PrintWriter(new File("output/test.txt"))
        writer.write("hello")
        writer.close()
    }
}
