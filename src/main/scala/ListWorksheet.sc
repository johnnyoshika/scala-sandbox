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

val l = List(1,2,3)
0 :: l
l ::: List(4,5,6)

//  operators ending in : are seen as method calls of the right-hand operand
val list1 = 1 :: 2 :: 3 :: 4 :: Nil
// the above is the same as
val list2 = 1 :: (2 :: (3 :: (4 :: Nil)))
// the above is the same as
Nil.::(4).::(3).::(2).::(1)
