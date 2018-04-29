type Occurrences = List[(Char, Int)]

def wordOccurrences(w: String): Occurrences =
  w.groupBy(s => s)
    .map(p => (p._1, p._2.length))
    .toList
    .sortWith((a, b) => a._1 < b._1)


val i0 = List(('c', 1) :: Nil)
val o0 = Nil :: i0

val i1 = List(('b', 1) :: o0(0), ('b', 1) :: o0(1))
val o1 = o0 ::: i1

val i2 = List(
  ('a', 1) :: o1(0),
  ('a', 2) :: o1(0),
  ('a', 1) :: o1(1),
  ('a', 2) :: o1(1),
  ('a', 1) :: o1(2),
  ('a', 2) :: o1(2),
  ('a', 1) :: o1(3),
  ('a', 2) :: o1(3))
val o2 = o1 ::: i2

def combinationsK(occurrences: Occurrences): List[Occurrences] =
  if (occurrences.isEmpty) List(List())
  else {
    val rest = combinationsK(occurrences.tail)
    val cycle = for {
      r <- rest
      x <- 1 to occurrences.head._2
    } yield (occurrences.head._1, x) :: r

    rest ::: cycle
  }

val t = wordOccurrences("abac")
combinationsK(t)

List(('b', 1)) == List(('b', 1))
List(('b', 1)) == List(('b', 1), ('b', 1))

val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 2))
val y = List(('d', 1))

def subtract(x: Occurrences, y: Occurrences): Occurrences =
  y.foldLeft(x)((a: Occurrences, b: (Char, Int)) => {
    val i = a.indexWhere(_._1 == b._1)
    a.updated(i, (a(i)._1, a(i)._2 - b._2))
  }).filterNot(_._2 == 0)

subtract(x, y)

def isSubset(x: Occurrences, y: Occurrences): Boolean =
  y.forall(a => x.exists(b => b._1 == a._1 && b._2 >= a._2))

isSubset(x, List(('k', 3)))


