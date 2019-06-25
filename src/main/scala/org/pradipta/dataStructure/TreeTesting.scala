package org.pradipta.dataStructure

class TreeTesting[T <: {def <(that : Int) : Boolean}](val arg : List[T]){
  def checkHead (that : Int) : Boolean =  arg.head < that
}
class SubTest (val x : Int) {
    def <  (arg : Int) : Boolean =   if (x < arg) true else false
}
import org.pradipta.dataType._

object TestTree extends App {
  //val treeTesting1 = new TreeTesting(1::2::5::Nil)
  //val treeTesting2 = new MyTree.TreeTesting[Int](10)
  /*val numberList1 = new RationalNumber(9,10) :: new RationalNumber(9,27) :: new RationalNumber(35,77) :: Nil
  val testTree = new CreateTree[RationalNumber](numberList1)
  testTree.printTree
  floatList = 7.5::1.2::2.3::3.4::2.5::Nil
  val floatTree = new BinaryTree[MathFloat](floatList)
  floatTree.printTree
  floatTree.addNode(8.2)
  floatTree.printTree
  println("")
  //println(floatTree.searchTree(3.4))
  //println(floatTree.searchTree(2.5))
  println(floatTree.searchTree(7.8))*/
  //val stringList = "A" :: "B" :: "C" :: "D" :: "E" :: Nil
  //val graph = new Graph[String](stringList)
  //graph.addUniRelation(List(("A", "E", 0), ("D", "B", 1 ), ("A", "C", 2)))
  //graph.addUniRelation(List(("A", "B", 5),("A", "C", 5),("A", "E", 0),("B", "D", 10),("B", "E", 10),("C", "B",7), ("C", "D",7), ("D", "C", 10), ("E", "D",7), ("E", "B",7), ("E", "A",7) ))

  //println(graph.isPathExist("A","D"))
  //println(graph.isPathExist("A","B"))
  //println(s"Result is " + SwapLetter.checkLetterSwap("abcdef", "abcdfe"))
  //println(s"Result is " + SwapLetter.checkLetterSwap("abcdef", "abcdef"))
 //println(s"Result is " + SwapLetter.checkLetterSwap("acbdef", "abcdef"))
  //println ("Final Count = "+ CoinProblemGoogle.checkCoinOptions(10, 1::2::5::Nil))
  //println ("Final Count = "+ CoinProblemGoogle.checkCoinOptions(10, 1:: Nil))
 // println ("Final Count = "+ CoinProblemGoogle.checkCoinOptions(10, 1:: 3::Nil))
  val floatList = 7.5::1.2::2.3::3.4::2.5::10.5::Nil
  val floatTree = new BinaryTree[MathFloat](floatList)
  floatTree.printTree
  def randomSelection[A] (seq : Seq[A]) : A={
    seq ( util.Random.nextInt(seq.length)  )
  }
  //val seq = Seq[String]("Pradipta","Siuli", "Shree")
  //println(randomSelection(seq))	//Shree



}