def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => Nil
  case y :: ys => y :: init(ys)
}

def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)

def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys1) => ys1
      case (xs1, Nil) => xs1
      case (x :: xs1, y :: ys1) =>
        if (ord.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}

def squareListPm(xs: List[Int]): List[Int] =
  xs match {
    case Nil => xs
    case y :: ys => y * y :: squareListPm(ys)
  }

def squareListMap(xs: List[Int]): List[Int] =
  xs map (x => x * x)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: _ =>
    val (eq, rest) = xs.span(y => y == x)
    eq :: pack(rest)
}

def encode[T](xs: List[T]): List[(T, Int)] = pack(xs).map { x =>
  (x.head, x.size)
}

def concat[T](xs: List[T], ys: List[T]): List[T] = {
  // foldRight receives [U, T] where U equals List[T], which responds to `::`
  (xs foldRight ys) (_ :: _)
  // foldLeft receives [T, U] where T in this case it's not defined, so doesn't respond to `::`
  // (xs foldLeft ys) (_ :: _)
}

concat(List(1, 2, 3, 4), List(9, 8, 7, 6))

encode(List("a", "a", "a", "b", "c", "c", "a"))

pack(List("a", "a", "a", "b", "c", "c", "a"))

squareListPm(List(1, 2, 3, 4, 5))

squareListMap(List(1, 2, 3, 4, 5))

msort(List(5, 3, 2, 4, -7, 1, -1, 0, -8))

init(List(1, 2, 3, 4)).map(_ * 2)

removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)