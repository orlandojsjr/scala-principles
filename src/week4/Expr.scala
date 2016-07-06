package week4

trait Expr {

  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def numValue = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def numValue = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}

class Main extends App {

  override def main(string: Array[String]) {
    println(eval(new Number(1)))
    println(eval(new Sum(new Number(1), new Number(10))))
  }

  def eval(e: Expr): Int = {
    if(e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknow expression " + e)
  }
}
