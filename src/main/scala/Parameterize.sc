// using Merge Sort (started with MergeSorUsingParisANdTuples.cs)

def mergeSort[T](xs: List[T])(lessThan: (T, T) => Boolean) = {
  val merge = mergeWith(lessThan)_

  def sort(xs: List[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (fst, snd) = xs splitAt n
      merge(sort(fst), sort(snd))
    }
  }
  sort(xs)
}

def mergeWith[T](lessThan: (T, T)=> Boolean)(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (lessThan(x, y)) x :: mergeWith(lessThan)(xs1, ys)
        else y :: mergeWith(lessThan)(xs, ys1)
    }

mergeSort(List(3,2,6,4))((x, y) => x < y)
mergeSort(List("blahblahblahblah", "sam", "michael", "cindy", "kyle"))((x, y) => x.length < y.length)
mergeWith((x: String, y: String) => x.length < y.length)(List("bob", "jackson"), List("stan", "kyle"))



