package week6

object test {
  println("Welcome to the Scala worksheet")
  
  val xs =  Array(1, 2, 3, 44)
  xs map (x => x * 2)
  
  val s =  "Hello World"
  s filter (_.isUpper)
  s exists (_.isUpper)
  s forall (_.isUpper)
  
  val pairs = List(1, 2, 3) zip s
  pairs unzip
  
  s flatMap( c => List(".", c))
  xs.sum
  xs.max
 
 
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{ case (x, y) => x * y }.sum
}