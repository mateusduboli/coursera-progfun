object Expressions {

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(left: Expr, right: Expr) extends Expr

  case class Prod(left: Expr, right: Expr) extends Expr

  case class Var(name: String) extends Expr


  object Expr {

    val referenceTable: Map[String, Int] = Map(
      "x" -> 2,
      "y" -> -2
    )

    def eval(e: Expr): Int = e match {
      case Number(n) => n
      case Sum(l, r) => eval(l) + eval(r)
      case Prod(l, r) => eval(l) * eval(r)
      case Var(name) => referenceTable(name)
    }

    def show(e: Expr): String = e match {
      case Number(n) => n.toString
      case Sum(l, r) => s"${show(l)} + ${show(r)}"
      case Prod(l: Sum, r) => s"(${show(l)}) * ${show(r)}"
      case Prod(l, r: Sum) => s"${show(l)} * (${show(r)})"
      case Prod(l, r) => s"${show(l)} * ${show(r)}"
      case Var(name) => name
    }
  }

  Expr.show(Sum(Number(2), Var("x")))
  Expr.eval(Sum(Number(2), Var("x")))

  Expr.show(Prod(Sum(Number(2), Number(3)), Var("x")))
  Expr.show(Prod(Var("y"), Sum(Number(2), Number(3))))

  Expr.eval(Prod(Var("y"), Sum(Number(2), Number(3))))
}