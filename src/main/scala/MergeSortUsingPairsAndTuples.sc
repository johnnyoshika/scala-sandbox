def mergeSort(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (fst, snd) = xs splitAt n
    mergeBetter(mergeSort(fst), mergeSort(snd))
  }
}

def merge(xs: List[Int], ys: List[Int]): List[Int] = {
  xs match {
    case Nil => ys
    case x :: xs1 =>
      ys match {
        case Nil => xs
        case y :: ys1 =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
  }
}

def mergeBetter(xs: List[Int], ys: List[Int]): List[Int] =
  (xs, ys) match {
    case (Nil, ys) => ys
    case (xs, Nil) => xs
    case (x :: xs1, y :: ys1) =>
      if (x < y) x :: mergeBetter(xs1, ys)
      else y :: mergeBetter(xs, ys1)
  }

mergeSort(List(1,50,2,3,4,2,35))
mergeBetter(List(1,3,50), List(2,9,21))

// just experiments...

3 / 2

3.0 / 2

List(1,2,3,4,5).splitAt(2)

List(1,2,3) match {
  case x :: y => (x, y)
}

List(1) match {
  case Nil => Nil
  case x :: y => (x, y)
}