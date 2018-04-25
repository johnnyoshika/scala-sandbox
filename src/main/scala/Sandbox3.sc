val l = List(1,2,3)
l.reduceRight(_ + _)

val e: List[Int] = Nil
e.foldLeft(0)(_ + _)

l.foldLeft("f")(_ + " " + _.toString)

l.foldRight("f")(_.toString + " " + _)

l.foldRight(l)(_ :: _)

l.foldLeft(l)(_ :+ _)

List(1,2,3).filter(2 >)
List(1,2,3).filter(< 2)

