Vector(1,2,3)
0 +: Vector(1,2,3) :+ 4

1 to 3
(1 to 3).map(x => (11 to 13).map(y => (x, y)))
(1 to 3).flatMap(x => (11 to 13).map(y => (x, y)))

((1 to 3) zip (4 to 6)).map(xy => xy._1 * xy._2).sum
((1 to 3) zip (4 to 6)).map{ case (x, y) => x * y }.sum


