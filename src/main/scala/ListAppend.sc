val l = List(1,2,3)
0 :: l
l ::: List(4,5,6)

//  operators ending in : are seen as method calls of the right-hand operand
val list1 = 1 :: 2 :: 3 :: 4 :: Nil
// the above is the same as
val list2 = 1 :: (2 :: (3 :: (4 :: Nil)))
// the above is the same as
Nil.::(4).::(3).::(2).::(1)
