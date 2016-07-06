package week5

object mergeSortImplicit {
  
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if(n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if(lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }                                               //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
  
  val nums = List(11, -1, 9, 4, 8, -5, 3)         //> nums  : List[Int] = List(11, -1, 9, 4, 8, -5, 3)
  msort(nums)((x: Int, y: Int) => x < y)          //> res0: List[Int] = List(-5, -1, 3, 4, 8, 9, 11)
  
  val fruits = List("apple", "orange", "pineapple", "banana")
                                                  //> fruits  : List[String] = List(apple, orange, pineapple, banana)
  msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
                                                  //> res1: List[String] = List(apple, banana, orange, pineapple)
}