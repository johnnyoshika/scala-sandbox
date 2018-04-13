object Closure extends App {
  var more = 1

  val addMore = (x: Int) => x + more

  println(addMore(10))

  more = 2

  println(addMore(10))

  val addMore2 = ((more: Int) => (x: Int) => x + more)(more)
  val addMore3 = (x: Int) => ((more: Int) => x + more)(more)

  println(addMore2(10))
  println(addMore3(10))

  more = 3

  println(addMore2(10))
  println(addMore3(10))

}
