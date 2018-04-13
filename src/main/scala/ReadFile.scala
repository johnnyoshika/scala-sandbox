import scala.io.Source

object ReadFile {
  def main(args: Array[String]): Unit = {
    val fileName = "C:/Users/Johnny/Downloads/todo.txt"
    val lines = Source
      .fromFile(fileName)
      .getLines()
      .toList

    val maxWidth = widthOfLength(longestLine(lines))

    lines
      .foreach(line => {
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
      })
  }

  def widthOfLength(s: String) = s.length.toString.length

  def longestLine(lines: List[String]) =
    lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
}
