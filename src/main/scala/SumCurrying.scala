object SumCurrying extends App {

  // apply f from a to b

  println("sumHigherOrder -------------------------")

  // higher order function with anonymous function
  def sumHigherOrder(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else
      f(a) + sumHigherOrder(f, a + 1, b)

  println(sumHigherOrder(x => x, 1, 3))
  println(sumHigherOrder(x => x * x, 1, 3))

  def sumInts(a: Int, b: Int) = sumHigherOrder(x => x, a, b)
  def sumSquare(a: Int, b: Int) = sumHigherOrder(x => x * x, a, b)

  println(sumInts(1, 3))
  println(sumSquare(1, 3))

  println("sumCurring -------------------------")

  // with currying
  def sumCurrying(f: Int => Int) = (a: Int, b: Int) => {
    def loop(a: Int, b: Int) : Int =
      if (a > b) 0
      else
        f(a) + loop(a + 1, b)

    loop(a, b)
  }

  println(sumCurrying(x => x)(1, 3))
  println(sumCurrying(x => x * x)(1, 3))

  def sumInts2 = sumCurrying(x => x)
  def sumSquare2 = sumCurrying(x => x * x)

  println(sumInts2(1, 3))
  println(sumSquare2(1, 3))

  println("sumCurryingSimplified -------------------------")

  def sumCurryingSimplified(f: Int => Int)(a: Int, b: Int) = {
    def loop(a: Int, b: Int) : Int =
      if (a > b) 0
      else
        f(a) + loop(a + 1, b)

    loop(a, b)
  }

  println(sumCurryingSimplified(x => x)(1, 3))
  println(sumCurryingSimplified(x => x * x)(1, 3))

  // use _ (placeholder notation) to get reference to second function
  def sumInts3 = sumCurryingSimplified(x => x)_
  def sumSquare3 = sumCurryingSimplified(x => x * x)_

  println(sumInts3(1, 3))
  println(sumSquare3(1, 3))
}
