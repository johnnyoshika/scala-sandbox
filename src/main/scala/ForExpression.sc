def isPrime(n: Int) = 2 until n forall(d => n % d != 0)

isPrime(5)
isPrime(9)

val n = 7

for {
  i <- 1 until n
  j <- 1 until i
  if (isPrime(i + j))
} yield (i, j)

for (i <- 1 until n if i > 3)
  yield i

for {
  i <- 1 to 3
  j <- 11 to 13
} yield (i, j)

// ----------------------------------------
// translating for expression to map, filter, and flatMap
// ----------------------------------------

// example 1
for (x <- 1 to 3) yield x * 2
(1 to 3).map(x => x * 2)

// example 2
def f = (x: Int) => x % 2 == 0
def e = (x: Int) => x * 2

for (x <- 1 to 3 if (x % 2 == 0)) yield x * 2
for (x <- 1 to 3 if f(x)) yield x * 2
for (x <- 1 to 3 if f(x)) yield e(x)

for (x <- (1 to 3).withFilter(x => x % 2 == 0)) yield x * 2
for (x <- (1 to 3).withFilter(f)) yield x * 2
for (x <- (1 to 3).withFilter(f)) yield e(x)

(1 to 3).withFilter(f).map(e)

// example 3
for (x <- (1 to 3); y <- (4 to 6)) yield (x, y)
(1 to 3).flatMap(x => for (y <- (4 to 6)) yield (x, y))
(1 to 3).flatMap(x => (4 to 6).map(y => (x,y)))