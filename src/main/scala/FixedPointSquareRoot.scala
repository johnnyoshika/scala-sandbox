object FixedPointSquareRoot extends App {
  def fixedPoint(f: Double => Double)(firstGuess: Double) {

    def goodEnough(guess: Double, next: Double): Boolean =
      Math.abs(guess - next) / guess < 0.001

    def iterate(guess: Double): Double = {
      println(guess)
      val next = f(guess)
      if (goodEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  // fun fact, see SquareRootUsingNewtonsMethod, (y + x / y) / 2 is the same there
  def sqrt(x: Int) = fixedPoint(y => (y + x / y) / 2)(1)

  def sqrtWithFixedPointAverageDamp(x: Int) = fixedPoint(averageDamp( y => x / y))(1)

  println(sqrt(2))
  println(sqrtWithFixedPointAverageDamp(2))
}
