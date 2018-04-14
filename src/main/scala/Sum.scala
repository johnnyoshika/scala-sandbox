object Sum extends App {
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else
      f(a) + sum(f, a + 1, b)

  println(sum(x => x, 1, 10))
  println(sum(x => x * x, 3, 5))


  // return function instead

  def sumFunc(f: Int => Int): (Int, Int) => Int = {
    def sumInner(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumInner(a + 1, b)

    sumInner
  }

  // simpler version of the above
  def sumFun2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumFun2(f)(a + 1, b)
}
