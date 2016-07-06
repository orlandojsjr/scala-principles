package week2

object curryng {
  println("Welcome to the Scala worksheet")

  println(product(x=>x * x)(3,4))
  println(productWithMapReduce(x=>x * x)(3,4))
  println(factorial(5))
  println(factorialWithMapReduce(5))

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if(a > b ) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  def productWithMapReduce(f: Int => Int)(a: Int, b:Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

  def product(f: Int => Int)(a: Int, b:Int): Int =
    if(a > b) 1 else f(a) * product(f)(a + 1, b)

  def factorialWithMapReduce(n: Int) = productWithMapReduce(x => x)(1, n)

  def factorial(n: Int) = product(x => x)(1, n)

}
