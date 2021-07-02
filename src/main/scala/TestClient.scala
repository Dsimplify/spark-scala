import java.io.{OutputStreamWriter, PrintWriter}
import java.net.Socket

object TestClient {
    def main(args: Array[String]): Unit = {
        val client = new Socket("localhost", 9999)
        val out = new PrintWriter(
            new OutputStreamWriter(
                client.getOutputStream,
                "UTF-8"
            )
        )

        out.print("i am king")
        out.flush()
        out.close()
        client.close()
    }
}
