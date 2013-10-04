import scala.annotation.tailrec

object TailSumation {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def sum(f: Int => Int, a : Int, b : Int) : Int = {
		@tailrec
  	def loop(a : Int, acc : Int) : Int= {
  		if(a > b) acc
  		else loop(a + 1,f(a) + acc)
  	}
  	loop(a,0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  sum(x => x * x * x, 0, 70)                      //> res0: Int = 6175225
}