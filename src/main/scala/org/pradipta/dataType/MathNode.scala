package org.pradipta.dataType

//abstract class MathNode [T]{
trait MathNode [T]{
    def < (that : List[T]) : Boolean
    def >(that : List[T]) : Boolean
    def == (that : List[T]) : Boolean
}
