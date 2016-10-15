object Lists {

  object List {
    def apply() = Nil

    def apply[T](x: T): List[T] = new Cons(x, Nil)

    def apply[T](a: T, b: T): List[T] = new Cons(a, apply(b))
  }

  trait List[+T] {
    def isEmpty: Boolean

    def head: T

    def tail: List[T]
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    override def isEmpty: Boolean = false

    override def toString: String = s"$head, $tail"
  }

  object Nil extends List[Nothing] {
    override def isEmpty: Boolean = true

    override def head: Nothing = throw new NoSuchElementException("Nil.head")

    override def tail: Nothing = throw new NoSuchElementException("Nil.tail")

    override def toString: String = "Nil"
  }

  def nth[T](list: List[T], n: Int): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) list.head
    else nth(list.tail, n - 1)
  }

  val x: List[Int] = new Cons(1, new Cons(2, new Cons(3, Nil)))

  List()

  List(1)

  List(1, 2)

  nth(x, 0)
  nth(x, 1)
  nth(x, 2)
  nth(x, 3)
}