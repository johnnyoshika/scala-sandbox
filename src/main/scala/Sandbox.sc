import java.math.BigInteger

val big = new BigInteger("12345")
big

if (true) 1 else false

List(1, false, "blah")
List(1,2,3)

List(1,2,3,2,10,4,3).reduceLeft((a, b) => if (a > b) a else b)
List(1,2,3,2,10,4,3).reduce((a, b) => if (a > b) a else b)
List(1,2,3,2,10,4,3).reduce((a, b) => if (a < b) a else b)

def and(x: Boolean, y: Boolean) = if (x) y else false
and(true, true)
and(true, false)
and(false, true)
and(false, false)

def or(x: Boolean, y: Boolean) = if (x) true else y
or(true, true)
or(true, false)
or(false, true)
or(false, false)


val food = "chips"
food match {
  case "po" => println("corn")
  case "chips" => println("salsa")
  case _ => println("nothing")
}

1 == 1.0

List(1,2,3) == List(1,2,3)

val result = for (i <- List(1,2,3) if i > 1)
  yield i
result

List(1,2,3).filter(x => x > 1)
List(1,2,3).filter(_ > 1)
List(1,2,3).foreach(println _)

7 toString

val myName = "johnny"
s"Hello, $myName"

def max(x: Int, y: Int) = if (x > y) x else y

max(11, 21)

def greet() = println("Welcome")

greet()

val maxPlus1 = {
  val someMax = max(10, 20)
  someMax + 1
}
println("maxPlus1 --------> " + maxPlus1.toString)

class Person(id: Int, val name: String)

val mike = new Person(1, "Mike")
mike.name
// mike.id --> private

1 + 2
(1).+(2)

// mutable
val moreNumbers = Array("zero", "one", "two")
moreNumbers(1) = "none"
moreNumbers.foreach(n => println(n + " "))

// immutable
val numbers = List(1,2,3,4)
numbers.foreach(n => println(n + " || "))
numbers.foreach(println)

for(n <- numbers)
  println(n)

for(i <- 0 to 2)
  println(i)


val list1 = List(1, 2)
val list2 = List(3, 4)
val list3 = list1 ::: list2
val list4 = 0 :: list3
val list5 = 1 :: 2 :: 3 :: Nil
list5.count(i => i < 3)
list5.mkString(",")

val myTuple = (1, "bob")
myTuple._1
myTuple._2

var jetSet = Set("Boeing", "Airbus")
jetSet = jetSet + "Leer"
jetSet.contains("Airbus")

val romanNumerals = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV")
romanNumerals(4)

"my" * 10

""" foo "HELP" \/\/ \n next"""

