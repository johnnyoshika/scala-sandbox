object SumTailRecursion extends App {

  // this is using currying, and that's why it's
  // ()(){} instead of () = () => {}
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }


  println(sum(x => x)(1, 10))
  println(sum(x => x * x)(3, 5))

}
