object Product {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def prod(f : Int => Int)(a : Int, b : Int): Int =
  	if (a > b) 1 else f(a) * prod(f)(a + 1, b)//> prod: (f: Int => Int)(a: Int, b: Int)Int
	
	def fact(n : Int) = prod(x => x)(1, n)    //> fact: (n: Int)Int
	
	fact(6)                                   //> res0: Int = 720
	
	def mapReduce(f : Int => Int, combine : (Int, Int) => Int) : Int = ???
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int)Int
}