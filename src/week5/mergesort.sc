package week5

object mergesort {
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if(n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if(x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }                                               //> msort: (xs: List[Int])List[Int]
  
  val nums =  List(11, -1, 9, 4, 8, -5, 3)        //> nums  : List[Int] = List(11, -1, 9, 4, 8, -5, 3)
  msort(nums)                                     //> res0: List[Int] = List(-5, -1, 3, 4, 8, 9, 11)
}