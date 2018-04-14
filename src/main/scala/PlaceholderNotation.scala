object PlaceholderNotation  extends  App {
  println(List(1,2,3,4,5).filter(_ > 3))
  println(List(1,2,3,4,5).filter(_ > 3))

  def multiple(op: (Int, Int) => Int, x: Int, y: Int) =
    op(op(x, y), op(x, y))

  println(multiple(_ + _, 1, 2))
}
