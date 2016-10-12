object Lists {
  trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    override def isEmpty: Boolean = false
  }

  class Nil[T] extends List[T] {
    override def isEmpty: Boolean = true

    override def head: Nothing = throw new NoSuchElementException("Nil.head")

    override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }

  def nth[T](list: List[T], n: Int): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) list.head
    else nth(list.tail, n - 1)
  }

  val x: List[Int] = new Cons(1, new Cons(2, new Cons(3, new Nil)))

  nth(x, 0)
  nth(x, 1)
  nth(x, 2)
  nth(x, 3)
}