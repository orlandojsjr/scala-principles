package week5

/*trait List[T] {
  def head: T
  def tail: List[T]
  def isEmpty: Boolean

  /*def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }

  def init[T](xs: List[T]): T = xs  match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  def concat[T](xs: List[T], ys: List[T]): T = xs  match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  def reverse[T](xs: List[T]): T = xs  match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y)
  }*/
}

class Nil[T] extends List[T] {
  def head = throw new java.util.NoSuchElementException("head of EmptyList")
  def tail = throw new java.util.NoSuchElementException("tail of EmptyList")
  def isEmpty = true
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object List {
  //List(1,2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T]() = new Nil
}*/
