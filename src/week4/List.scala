package week4

trait List[T] {
  def head: T
  def tail: List[T]
  def isEmpty: Boolean
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
}
