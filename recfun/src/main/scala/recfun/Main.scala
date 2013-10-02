package recfun
import common._

object Main {
  def main(args: Array[String]) {
    //    println("Pascal's Triangle")
    //    for (row <- 0 to 10) {
    //      for (col <- 0 to row)
    //        print(pascal(col, row) + " ")
    //      println()
    //    }

    print(countChange(4, List(1, 2)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    var mutableChars = chars
    def balanceRec: Boolean = {
      if (mutableChars.isEmpty)
        true
      else if (mutableChars.head == '(') {
        mutableChars = mutableChars.drop(1)
        !balanceRec && balanceRec
      } else if (mutableChars.head == ')') {
        mutableChars = mutableChars.drop(1)
        false
      } else {
        mutableChars = mutableChars.drop(1)
        balanceRec
      }
    }
    balanceRec
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeRec(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) 0
      else if (money == 0) 1
      else {
        val count = countChangeRec(money - coins.head, coins) +
        		countChangeRec(money, coins.tail)
        count
      }
    }
    countChangeRec(money, coins)
  }
}
