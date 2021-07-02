import java.io.{BufferedReader, InputStreamReader}
import java.net.{ServerSocket, Socket}

object TestServer {
    def main(args: Array[String]): Unit = {
        val server = new ServerSocket(9999)
        while (true) {
            val socket: Socket = server.accept()
            val reader = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream,
                    "UTF-8"
                )
            )
            var s = ""
            var flag = true
            while (flag) {
                s = reader.readLine()
                if (s != null) {
                    println(s)
                } else {
                    flag = false
                }
            }
        }
    }
}


