
import scala.annotation.tailrec

object HelloWorld {
   def main(args: Array[String]) {
      println("Hello, world!")
      println(fatorial(5, 1))
   }
   
   @tailrec
   def fatorial(x: Int, acc: Int): Int = {
       if(x == 0) acc else fatorial(x - 1, x * acc)
   }
   
}