type Occurrences = List[(Char, Int)]

def wordOccurrences(w: String): Occurrences =
  w.groupBy(s => s)
    .map(p => (p._1, p._2.length))
    .toList
    .sortWith((a, b) => a._1 < b._1)

wordOccurrences("abaccd")

val dictionary = List("ate", "tea", "eat", "bob", "jen")

val dictionaryByOccurences = dictionary.map(w => (wordOccurrences(w), w))
  .groupBy(p => p._1)
  .toList
  .map(p => (p._1, p._2.map(s => s._2)))
  .toMap

dictionaryByOccurences
  .find(m => m._2.contains("ate"))
  .head
  ._2
  .filterNot(s => s == "ate")


val c = wordOccurrences("abab")

val i0 = List(('c', 1) :: Nil)
val o0 = Nil :: i0

val i1 = List(('b', 1) :: o0(0), ('b', 1) :: o0(1))
val o1 = o0 ::: i1

val i2 = List(('a', 1) :: o1(0),
  ('a', 2) :: o1(0),
  ('a', 1) :: o1(1),
  ('a', 2) :: o1(1),
  ('a', 1) :: o1(2),
  ('a', 2) :: o1(2),
  ('a', 1) :: o1(3),
  ('a', 1) :: o1(3))
val o2 = o1 ::: i2

def combinationsK(occurrences: Occurrences) = {
  def permutations(occurrences: Occurrences): List[Occurrences] =
//    if (occurrences.isEmpty) Nil
//    else {
      if (occurrences.length == 1) {
        val cycle = for {
          x <- 1 to occurrences.head._2
        } yield List((occurrences.head._1, x))

        Nil ++ cycle
      } else {
        val other = permutations(occurrences.tail)
        val cycle = for {
          o <- other
          x <- 1 to occurrences.head._2
        } yield (occurrences.head._1, x) :: o

        other ::: cycle
      }
//    }

  permutations(occurrences)
}

val t = wordOccurrences("abac")
combinationsK(t)

