package week3

import java.util.NoSuchElementException

object ListRunner {
  def main(args: Array[String]): Unit = {
    def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

    val a = singleton[Int](1)
    val b = singleton(1)
    val c = singleton[Boolean](true)
    val d = singleton(true)

    // object List with apply methods below allows us to call List in this way
    val e = List
    val f = List(1)
    val g = List(1,2)
  }
}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.talk")
}

object List {
  def apply[T]() = new Nil
  def apply[T](x1: T) = new Cons(x1, new Nil)
  def apply[T](x1: T, x2: T) = new Cons(x1, new Cons(x2, new Nil))
}