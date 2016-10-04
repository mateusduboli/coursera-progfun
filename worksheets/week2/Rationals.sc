val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.numer
x.denum
x.sub(y).sub(z)
y.add(y)
x.less(y)
y.max(x)

new Rational(2)

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private def g = gcd(x, y)

  def numer = x / g
  def denum = y / g

  def add(that: Rational): Rational = {
    new Rational(
      numer * that.denum + that.numer * denum,
      denum * that.denum)
  }

  def less(that: Rational): Boolean = numer * that.denum < that.numer * denum

  def max(that: Rational): Rational = if (this.less(that)) that else this

  def neg: Rational = {
    new Rational(-numer, denum)
  }

  def sub(that: Rational): Rational = {
    this.add(that.neg)
  }

  override def toString: String = s"$numer/$denum"
}