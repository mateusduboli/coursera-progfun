object Rationals {

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.numer
  x.denum
  x - y - z
  y + y
  x < y
  y max x

  new Rational(2)

  class Rational(x: Int, y: Int) {
    require(y != 0, "denominator must be nonzero")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private def g = gcd(x, y)

    def numer = x / g

    def denum = y / g

    def +(that: Rational): Rational = {
      new Rational(
        numer * that.denum + that.numer * denum,
        denum * that.denum)
    }

    def <(that: Rational): Boolean = numer * that.denum < that.numer * denum

    def max(that: Rational): Rational = if (this < that) that else this

    def unary_- : Rational = {
      new Rational(-numer, denum)
    }

    def -(that: Rational): Rational = {
      this + -that
    }

    override def toString: String = s"$numer/$denum"
  }

}
