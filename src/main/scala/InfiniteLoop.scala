object InfiniteLoop extends App {
  def loop : Int = loop

  //  loop // infinite loop

  def callByName(x: Int, y: => Int) = x

  callByName(5, loop)
  println("done!")
}
