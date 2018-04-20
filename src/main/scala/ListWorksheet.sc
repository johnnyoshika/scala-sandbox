List(1,2,3).contains(2)
List(1,2,3).contains(4)

List((1, 'A'), (2, 'B'))
List((1, 'A'), (2, 'B'))
  .find(_._1 == 1)
  .head

// Concatenation
1 :: 2 :: 3 :: Nil
1 :: List(2,3)
List(1,2) :: List(1,2)
List(1,2) ::: List(1,2)
List(1,2) ++ List(1,2)
List(1,2) :+ 3

List(1,2,3) updated (1, 10)

List(1,2,3) indexOf 2

List(1,2,3).length
List(1,2,3).last
List(1,2,3).init
List(1,2,3) take 2
List(1,2,3) drop 2
List(1,2,3)(1)

List(1,2,3).reverse

List(1,2,3,4).splitAt(2)