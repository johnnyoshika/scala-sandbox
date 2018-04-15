object InSetRunner {
  def main(args: Array[String]): Unit = {
    val t1 = new NonEmpty(3, new Empty, new Empty)
    println(t1)
    val t2 = t1 incl 4
    println(t2)
    val t3 = t2 incl 2
    println(t3)

    val u1 = new NonEmpty(12, new Empty, new Empty)
    println(u1)
    val u2 = u1 incl 8
    println(u2)
    val u3 = u2 incl 20
    println(u3)

    val t4 = t3 union u3
    println(t4)
  }
}

abstract class InSet {
  def contains(x: Int): Boolean
  def incl(x: Int): InSet
  def union(other: InSet): InSet
}

class Empty extends InSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): InSet = new NonEmpty(x, new Empty, new Empty)

  override def union(other: InSet): InSet = other

  override def toString = "."
}

class NonEmpty(elem: Int, left: InSet, right: InSet) extends InSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): InSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def union(other: InSet): InSet =
    ((left union right) union other) incl elem


  override def toString = "{" + left + elem + right + "}"
}
