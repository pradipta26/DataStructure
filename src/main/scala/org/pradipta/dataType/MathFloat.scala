package org.pradipta.dataType

class MathFloat (val arg : Double) extends MathNode[MathFloat] {
  override def toString: String = s"$arg"

  override def <(that: List[MathFloat]): Boolean = arg < that.head.arg

  override def >(that: List[MathFloat]): Boolean = arg > that.head.arg

  override def ==(that: List[MathFloat]): Boolean = arg == that.head.arg

  def ==(that: MathFloat): Boolean = arg == that.arg

}
object MathFloat{
  implicit def floatToMathFloatList (arg : List[Double]) = arg.map( new MathFloat(_))

  implicit def floatToMathFloat (arg : Double) = new MathFloat(arg)
}
