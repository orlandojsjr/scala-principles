package week2

import scala.annotation.tailrec

object hirghorder {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  println(sumOfInts(1,2))                         //> 3

  println(sumOfCubes(1,2))                        //> 9

  println(fact(4))                                //> 24
  println(fact(5))                                //> 120
  println(sumOfFact(4, 5))                        //> 144

  def sum(f: Int => Int, a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sum(f, a + 1, b)  //> sum: (f: Int => Int, a: Int, b: Int)Int

  //@tailrec
  def sumTailrec(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = if(a > b) acc else loop(a + 1 , acc + f(a))
    loop(a, 0)
  }                                         //> sumTailrec: (f: Int => Int, a: Int, b: Int)Int

  def sumOfInts(a: Int, b : Int): Int =
    sumTailrec(x => x, a: Int, b: Int)        //> sumOfInts: (a: Int, b: Int)Int

  def sumOfCubes(a: Int, b : Int): Int =
    sumTailrec(x => x * x * x, a: Int, b: Int)//> sumOfCubes: (a: Int, b: Int)Int

  def sumOfFact(a: Int, b: Int): Int =
    sumTailrec(fact, a, b)                    //> sumOfFact: (a: Int, b: Int)Int

  def fact(a: Int): Int = if(a == 0) 1 else a * fact(a - 1) //> fact: (a: Int)Int

}
