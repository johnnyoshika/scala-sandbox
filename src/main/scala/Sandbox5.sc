type Word = String
type Sentence = List[Word]
type Occurrences = List[(Char, Int)]
val dictionary = List("i", "love", "you", "olive")

def wordOccurrences(w: Word): Occurrences =
  w
    .toLowerCase()
    .groupBy(s => s)
    .map(p => (p._1, p._2.length))
    .toList
    .sortWith((a, b) => a._1 < b._1)

def sentenceOccurrences(s: Sentence): Occurrences =
  wordOccurrences(s.mkString.replaceAll("[^A-Za-z]", "").toLowerCase)

lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] =
  dictionary
    .map(w => (wordOccurrences(w), w))
    .groupBy(p => p._1)
    .toList
    .map(p => (p._1, p._2.map(s => s._2)))
    .toMap

def wordAnagrams(word: Word): List[Word] =
  dictionaryByOccurrences
    .find(m => m._2.contains(word))
    .head
    ._2

def combinations(occurrences: Occurrences): List[Occurrences] =
  if (occurrences.isEmpty) List(List())
  else {
    val rest = combinations(occurrences.tail)
    val cycle = for {
      r <- rest
      x <- 1 to occurrences.head._2
    } yield (occurrences.head._1, x) :: r

    rest ::: cycle
  }

def subtract(x: Occurrences, y: Occurrences): Occurrences =
  y.foldLeft(x)((a: Occurrences, b: (Char, Int)) => {
    val i = a.indexWhere(_._1 == b._1)
    a.updated(i, (a(i)._1, a(i)._2 - b._2))
  }).filterNot(_._2 == 0)

def isSubset(x: Occurrences, y: Occurrences): Boolean =
  y.forall(a => x.exists(b => b._1 == a._1 && b._2 >= a._2))

val sentence: Sentence = List("I", "love", "you")
val sentenceO = sentenceOccurrences(sentence)
val combosAll = combinations(sentenceO)

// you, i, love, olive
val combos = combosAll.filter(dictionaryByOccurrences.contains(_))
val words0 = dictionaryByOccurrences(combos(0))
val words0_0 = words0(0)

val sentence1 = subtract(sentenceO, combos(0))
val combosAll1 = combinations(sentence1)
val combos1 = combosAll1.filter(dictionaryByOccurrences.contains(_))
val words1 = dictionaryByOccurrences(combos1(0))
val words1_0 = words1(0)

val sentence2 = subtract(sentence1, combos1(0))
val combosAll2 = combinations(sentence2)
val combos2 = combosAll2.filter(dictionaryByOccurrences.contains(_))
val words2 = dictionaryByOccurrences(combos2(0))
val words2_0 = words2(0)

val sentence3 = subtract(sentence2, combos2(0))
val words3_0 = Nil

words0_0 :: words1_0 :: words2_0 :: words3_0

def sentenceAnagrams(sentence: Sentence): List[Sentence] = {
  def anagrams(sentenceOccurences: Occurrences): List[Sentence] =
    if (sentenceOccurences.isEmpty) List(List())
    else
      for {
        combo <- combinations(sentenceOccurences)
        if (dictionaryByOccurrences.contains(combo))
        word <- dictionaryByOccurrences(combo)
        anagram <- anagrams(subtract(sentenceOccurences, combo))
      } yield {
        word :: anagram
      }

  anagrams(sentenceOccurrences(sentence))
}

sentenceAnagrams(List("I", "love", "you"))