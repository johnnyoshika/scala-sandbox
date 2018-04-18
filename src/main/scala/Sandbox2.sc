import week3._

def nth(n: Int, numbers: List[Int]): Int =
  if (numbers.isEmpty) throw new IndexOutOfBoundsException
  else if (n == 0) numbers.head
  else nth(n - 1, numbers.tail)

val fiveToOne =
  new Cons(5,
    new Cons(4,
      new Cons(3,
        new Cons(2,
          new Cons(1,
            new Nil)))))

nth(2, fiveToOne)
nth(8, fiveToOne)





