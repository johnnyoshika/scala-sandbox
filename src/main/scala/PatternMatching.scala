package week4

trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

object ExprRunner extends App {
  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Sum(l, r) => show(l) + " + " + show(r)
  }

  println(show(Sum(Number(2), Number(3))))
}