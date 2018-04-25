object polynomials {
  class Poly(val terms: Map[Int, Double]) {
    def + (other: Poly) = new Poly(terms ++ other.terms map adjust)

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      terms get exp match {
        case Some(coeff1) => exp -> (coeff + coeff1)
        case None => exp -> coeff
      }
    }

    override def toString: String =
      (for ((exp, coeff) <- terms.toList.sorted.reverse)
        yield coeff + "x^" + exp) mkString "+"
  }

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))

  p1 + p2


  class PolyWithFoldLeft(terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms = terms0 withDefaultValue(0.0)

    def + (other: PolyWithFoldLeft) = new PolyWithFoldLeft((other.terms foldLeft(terms))(addTerm))

    def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }

    override def toString: String =
      (for ((exp, coeff) <- terms.toList.sorted.reverse)
        yield coeff + "x^" + exp) mkString "+"
  }

  val p3 = new PolyWithFoldLeft(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
  val p4 = new PolyWithFoldLeft(0 -> 3.0, 3 -> 7.0)

  p3 + p4

}