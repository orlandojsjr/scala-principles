package week5

import math.Ordering

object mergeSortOrdering {
  
  def msort[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if(n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if(ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(ord), msort(snd)(ord))
    }
  }
  
  val nums = List(11, -1, 9, 4, 8, -5, 3)
  msort(nums)(Ordering.Int)
  
  val fruits = List("apple", "orange", "pineapple", "banana")
  msort(fruits)(Ordering.String)
}