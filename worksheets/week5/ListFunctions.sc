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


msort(List(5, 3, 2, 4, -7, 1, -1, 0, -8))

init(List(1, 2, 3, 4))

removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)