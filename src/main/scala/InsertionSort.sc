// quadratic (n2)

def insertionSort(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else
    insert(xs.head, insertionSort(xs.tail))

def insert(x: Int, xs: List[Int]): List[Int] =
  if (xs.isEmpty || x <= xs.head)
    x :: xs
  else
    xs.head :: insert(x, xs.tail)

insertionSort(List(2,5,3,19,3,6,4))

