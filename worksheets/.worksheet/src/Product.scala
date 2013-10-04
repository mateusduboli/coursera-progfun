object Product {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet");$skip(98); 
  def prod(f : Int => Int)(a : Int, b : Int): Int =
  	if (a > b) 1 else f(a) * prod(f)(a + 1, b);System.out.println("""prod: (f: Int => Int)(a: Int, b: Int)Int""");$skip(42); 
	
	def fact(n : Int) = prod(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(11); val res$0 = 
	
	fact(6);System.out.println("""res0: Int = """ + $show(res$0));$skip(74); 
	
	def mapReduce(f : Int => Int, combine : (Int, Int) => Int) : Int = ???;System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int)Int""")}
}
