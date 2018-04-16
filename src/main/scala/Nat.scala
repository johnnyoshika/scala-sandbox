// Natural number is a positive integer that includes zero

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero = true
  def predecessor = throw new UnsupportedOperationException
  def successor = new Succ(this)
  def +(that: Nat) = that
  def -(that: Nat) =
    if (that.isZero) this
    else throw new UnsupportedOperationException

  override def toString = "Zero"
}

class Succ(n: Nat) extends Nat {
  def isZero = false
  def predecessor = n
  def successor = new Succ(this)

  def +(that: Nat) =
    if (that.isZero) this
    else successor + that.predecessor

  // better solution provided by Martin Odersky
  // def +(that: Nat)= new Succ(n + that)

  def -(that: Nat) =
    if (that.isZero) this
    else predecessor - that.predecessor

  override def toString = n.toString + "+1"
}

object NatRunner extends App {
  println(Zero)
  val one = new Succ(Zero)
  val two = new Succ(new Succ(Zero))
  val three = new Succ(new Succ(new Succ(Zero)))

  val onePlusZero = one + Zero
  println(onePlusZero)

  val onePlusTwo = one + two
  println(onePlusTwo)

  val twoPlusThree = two + three
  println(twoPlusThree)

  val threeMinusTwo = three - two
  println(threeMinusTwo)
}