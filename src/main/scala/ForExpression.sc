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