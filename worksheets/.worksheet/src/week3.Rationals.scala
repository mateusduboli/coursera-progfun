package week3

object Rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(30); 

  val x = new Rational(1, 3);System.out.println("""x  : week3.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : week3.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week3.Rational = """ + $show(z ));$skip(13); val res$0 = 

  x - y - z;System.out.println("""res0: week3.Rational = """ + $show(res$0))}
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
