object TailRecursionFactorial extends App {
  // non-tail recursion
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  // tail recursion version
  def tailRecursionFactoria(n: Int) = {
    def loop(accumulator: Int, n: Int): Int =
      if (n == 0) accumulator else loop(accumulator * n, n - 1)

    loop(1, n)
  }

  println(factorial(10))
  println(tailRecursionFactoria(10))

}
