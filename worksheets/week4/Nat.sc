object Nat {

  // Peano numbers
  abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat = new Succ(this)
    def + (that: Nat): Nat
    def - (that: Nat): Nat
  }

  object Zero extends Nat {
    override def isZero: Boolean = true

    override def predecessor: Nat = throw new Error("No predecessor to zero")

    override def +(that: Nat): Nat = that

    override def -(that: Nat): Nat = {
      if (that.isZero) Zero
      else throw new Error("You can't subtract from Zero")
    }

    override def toString: String = "0"
  }

  class Succ(n: Nat) extends Nat {
    override def isZero: Boolean = false

    override def predecessor: Nat = n

    override def +(that: Nat): Nat = {
      if (that.isZero) this
      else new Succ(this.predecessor + that)
    }

    override def -(that: Nat): Nat = {
      if (that == this) Zero
      else if (that.isZero) this
      else this.predecessor - that.predecessor
    }

    override def toString: String = s"1 + $n"
  }

  val two = Zero
    .successor
    .successor

  val four = two + two

  four - four

  val one = two.predecessor

  one - one
}