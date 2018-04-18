def times(chars: List[Char]): List[(Char, Int)] = {
  def timesIter(chars: List[Char]): List[Char] =
    if (chars.isEmpty)
      Nil
    else
      chars.head :: timesIter(chars.tail)

  // group will look something like this:
  // Map(b -> List(b), a -> List(a, a))
  val group = timesIter(chars).groupBy(c => c)
  group.keys.map(k => (k, group(k).length)).toList
}


abstract class CodeTree
case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
case class Leaf(char: Char, weight: Int) extends CodeTree

val l1 = List('a', 'b', 'a')
val group1 = l1.groupBy(i => i)
group1.keys
group1.keys.map(k => (k, group1(k).length))
  .toList
//group1('z') // NoSuchElementException
group1.keys.exists(_ == 'z')

val l2 = List("m brown","m smith","k dorm","m jens", "k keet")
val group2 = l2.groupBy(_.charAt(0))
group2('k')
group2.keys


val t = times("abacfabce".toList)
val leaves = t.sortWith(_._2 < _._2)
  .map(pair => new Leaf(pair._1, pair._2))

new Fork(leaves.head, leaves.tail.head, leave.head.toList :: leaves.tail.head.toList, ) :: leaves.drop(2)

