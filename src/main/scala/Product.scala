object Product extends App {
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else
      f(a) * product(f)(a + 1, b)

  println(product(x => x * x)(3, 4))

  def factorial(n: Int): Int =
      product(x => x)(1, n)

  println(factorial(4))

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else
      combine(f(a),  mapReduce(f, combine, zero)(a + 1, b))

  println(mapReduce(x => x * x, (x, y) => x * y, 1)(3, 4))

  // product as a function of mapReduce

  def productMapReduce(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
  def factorialMapReduce(n: Int): Int = productMapReduce(x => x)(1, n)

  println(factorialMapReduce(4))

}
