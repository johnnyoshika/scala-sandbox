package week3

import java.util.NoSuchElementException

object ListRunner {
  def main(args: Array[String]): Unit = {
    def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

    val a = singleton[Int](1)
    val b = singleton(1)
    val c = singleton[Boolean](true)
    val d = singleton(true)
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
