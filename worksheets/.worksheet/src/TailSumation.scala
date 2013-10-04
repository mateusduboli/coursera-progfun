import scala.annotation.tailrec

object TailSumation {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 
  println("Welcome to the Scala worksheet");$skip(177); 
  def sum(f: Int => Int, a : Int, b : Int) : Int = {
		@tailrec
  	def loop(a : Int, acc : Int) : Int= {
  		if(a > b) acc
  		else loop(a + 1,f(a) + acc)
  	}
  	loop(a,0)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(29); val res$0 = 
  sum(x => x * x * x, 0, 70);System.out.println("""res0: Int = """ + $show(res$0))}
}
