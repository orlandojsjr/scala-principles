package week6

object pairs {
  println("Welcome to the Scala worksheet")
  
  def isPrime(n: Int) = (2 until n) forall(n % _ != 0)
  
  val n = 7
  
  (1 until n) flatMap(i =>
    (1 until i) map (j => (i, j))) filter (pair =>
      isPrime(pair._1 + pair._2))
                                                  
  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)
  
  
  def scalarProduct(xs: List[Double], ys: List[Double]): Double =
    for {
      (x,y) <- xs zip ys
    } yield x * y
    
    def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{ case (x, y) => x * y }.sum
}