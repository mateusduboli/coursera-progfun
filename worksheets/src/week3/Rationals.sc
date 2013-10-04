package week3

object Rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val x = new Rational(1, 3)                      //> x  : week3.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : week3.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week3.Rational = 3/2

  x - y - z                                       //> res0: week3.Rational = -79/42
}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def +(that: Rational) =
    new Rational(
      numer * that.denom +
        denom * that.numer,
      denom * that.denom)

  def unary_- =
    new Rational(-numer, denom)

	def -(that : Rational) = this + (- that)

  override def toString = numer + "/" + denom
}