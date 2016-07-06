object sqrt {
  println("Welcome to the Scala worksheet")

"123 Main Street".replaceAll("[0-9]", "x").last

"/home/vmspace/orlando.txt".replaceAll("\\\\", "/").split("/").last

  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.0001
    
    sqrtIter(1.0)
    
  }
  sqrt(2)
  sqrt(4)
  
  sqrt(1e-6)
  sqrt(1e60)
}