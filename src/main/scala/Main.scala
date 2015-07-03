import scala.io.StdIn._

object Main {
    def main(args: Array[String]): Unit = {
        val code = io.Source.fromFile("src/main/data.txt").mkString.toCharArray
        val l = code.length
        var arr = Array.fill[Int](30000)(0)

        var i = 0
        var t = 0
        var j = 0

        while (j < l) {
            if (code(j).equals('>'))
                i += 1
            if (code(j) == '<')
                i -= 1
            if (code(j) == '+')
                arr(i) += 1
            if (code(j) == '-')
                arr(i) -= 1
            if (code(j) == ',')
                readLine()
            if (code(j) == '.') {
                print(Character.toString(arr(i).toChar))
            }
            if (code(j) == '[') {
                if (arr(i) == 0) {
                    t += 1
                    while (t != 0) {
                        j += 1
                        if (code(j) == '[')
                            t += 1
                        if (code(j) == ']')
                            t -= 1
                    }
                }
            }
            else if (code(j) == ']') {
                if (arr(i) != 0) {
                    if (code(j) == ']')
                        t += 1
                    while (t != 0) {
                        j -= 1
                        if (code(j) == '[')
                            t -= 1
                        if (code(j) == ']')
                            t += 1
                    }
                    j -= 1
                }
            }
            j += 1
        }
    }
}
