import sun.text.resources.BreakIteratorInfo

class Rational(n: Int, d: Int) {
  require(d != 0)

  // these 3 initializer will be placed in the primary constructor
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1) // auxiliary constructor

  def + (other: Rational): Rational =
    new Rational(
      numer * other.denom + other.numer * denom,
      denom * other.denom
    )

  def + (other: Int): Rational =
    this + new Rational(other)

  def - (other: Rational): Rational =
    new Rational(
      numer * other.denom - other.numer * denom,
      denom * other.denom
    )

  def - (other: Int): Rational =
    this - new Rational(other)

  def * (other: Rational): Rational =
    new Rational(
      numer * other.numer,
      denom * other.denom
    )

  def * (other: Int): Rational =
    this * new Rational(other)

  def / (other: Rational): Rational =
    new Rational(
      numer * other.denom,
      denom * other.numer
    )

  def / (other: Int): Rational =
    this / new Rational(other)

  def lessThan(other: Rational) =
    numer * other.denom < other.numer * denom

  def moreThan(other: Rational) = !lessThan(other)

  override def toString: String = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object TestRational extends App {
  val half = new Rational(1, 2)
  val whole = half + half
  val twoThirds = new Rational(2, 3)

  val five = new Rational(5)

  val something = new Rational(66, 42)

  println(whole)
  println(half + twoThirds)
  println(whole lessThan twoThirds)
  println(something)
  println(half * half)
  println(half * 10)

  implicit def intToRational(x: Int) = new Rational(x)
  println(10 * half)
}
