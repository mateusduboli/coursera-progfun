object HighOrderFunctions {

  def sum(f: Int => Int)(a: Int, b: Int): Int = rangeReduce(_ + _, 0)(f)(a, b)

  def product(f: Int => Int)(a: Int, b: Int): Int = rangeReduce(_ * _, 1)(f)(a, b)

  def rangeReduce(combine: (Int, Int)  => Int, zero: Int)
                 (f: Int => Int)
                 (a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, combine(f(a), acc))
    }
    loop(a, zero)
  }

  def factorial(n: Int): Int = product(identity)(1, n)

}
