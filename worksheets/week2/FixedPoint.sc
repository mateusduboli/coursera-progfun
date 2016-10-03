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

  fixedPoint(x => 1 + x / 2)(1)
}