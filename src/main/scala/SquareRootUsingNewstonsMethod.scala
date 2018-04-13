object SquareRootUsingNewstonsMethod extends App {
  def sqrt(x: Double): Double = {

    def goodEnough(guess: Double): Boolean
      = Math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2 // mean of guess and guess / x (Newton's method)

    def sqrtIter(guess: Double): Double =
      if (goodEnough(guess)) guess
      else sqrtIter(improve(guess))

    sqrtIter(1)
  }

  println(sqrt(2))
  println(sqrt(4))
  println(sqrt(1e60))
  println(sqrt(1e-6))
}
