package funsets

object week3 {
  val t1 = new NonEmpty(3, new Empty, new Empty)  //> t1  : funsets.NonEmpty = {.3.}
  val t2 = t1 incl 4 incl 2 incl 1 incl 10        //> t2  : funsets.IntSet = {{{.1.}2.}3{.4{.10.}}}
}

abstract class IntSet {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other

  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, rigth: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) rigth contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, rigth)
    else if (x > elem) new NonEmpty(elem, left, rigth incl x)
    else this

  def union(other: IntSet): IntSet = (left union rigth) union other incl elem

  override def toString = "{" + left + elem + rigth + "}"

}