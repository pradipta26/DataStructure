package org.pradipta.dataType
import scala.language.implicitConversions

class RationalNumber (numerator : Int, denomerator : Int)  extends MathNode[RationalNumber]{

    require(denomerator != 0)
    val gcm = gcmFunc(numerator,denomerator)
    val numor = numerator / gcm
    val denom = denomerator / gcm
    def this(n : Int) = this (n, 1)
    private def gcmFunc (a : Int, b : Int) : Int = if (b == 0) a else gcmFunc (b, a%b)
    override def toString: String = s"$numor/$denom"
    def + (that : RationalNumber) :  RationalNumber = new RationalNumber(numor * that.denom + denom * that.numor , (denom * that.denom))
    def + (i : Int) :  RationalNumber = new RationalNumber((numor + i* denom) , denom)
  //def <[T](that : T) : Boolean
    override def < (that : List[RationalNumber]) : Boolean =  numor * that.head.denom < that.head.numor * denom
    override def >(that : List[RationalNumber]) : Boolean = numor * that.head.denom > that.head.numor * denom
    override def == (that : List[RationalNumber]) : Boolean = numor * that.head.denom == that.head.numor * denom
    //def max (that : RationalNumber) : RationalNumber = if (this < that) that else this
  }

  object RationalNumber{
    implicit def intToRationalNumber (i : Int) : RationalNumber = new RationalNumber(i)
   }

