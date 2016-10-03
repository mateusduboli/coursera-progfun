import scala.math.abs

object FixedPoint {
  val tolerance = 0.000001

  def isCloseEnought(x: Double, y: Double): Boolean = {
    abs((x - y) / x) / x < tolerance
  }

  def fixedPoint(f: Double => Double)(guess: Double): Double = {
    def loop(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnought(guess, next)) next
      else loop(next)
    }
    loop(guess)
  }

  def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

  def sqrt(x: Double): Double = fixedPoint(averageDamp(y => x / y))(1.0)

  fixedPoint(x => 1 + x / 2)(1)

  sqrt(2)
}