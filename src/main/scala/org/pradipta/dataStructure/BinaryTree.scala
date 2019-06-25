package org.pradipta.dataStructure

import org.pradipta.dataType._

class BinaryTree[T <: MathNode[T] ](val num: List[T]) {
  require(num.size != 0)

  class TreeNode[T] (val value : List[T]){
    var parentNode : Option[TreeNode[T]] = None //???
    var leftNode : Option[TreeNode[T]] = None
    var rightNode : Option[TreeNode[T]] = None
    var depth = 0
  }

  private val treeNodes: List[TreeNode[T]] = for (i <- num) yield {
    new TreeNode(List(i))
  }

  val rootNode: TreeNode[T] = treeNodes.head
  println(s"\nRoot Node Created with value ${rootNode.value.head} \nCreating Binary Tree of type ${rootNode.value.head.getClass}")
  setNodes

  //Public Methods
  def printTree : Unit = printNode(rootNode)

  def addNode (value: T): Unit = {
    val node = new  TreeNode[T](List(value))
    setNodePosition[T](rootNode, node)
  }

  def searchTree ( value : T): Boolean = {
    val node = new TreeNode[T](List(value))
    search(node, rootNode)
  }

  //Private Methods
  private def setNodes : Unit = treeNodes.tail.foreach(node => setNodePosition[T](rootNode, node))

  private def setNodePosition[T <: {def ==(that : List[T]) : Boolean; def <(that : List[T]) : Boolean; def >(that : List[T]): Boolean}]
                        (parentNode : TreeNode[T], node: TreeNode[T], depth : Int = 1): Unit = {

    if (parentNode.value.headOption.get == node.value){
      println ("Duplicate node found " + parentNode.value.headOption.get)
    }
    else if (parentNode.value.headOption.get > node.value && parentNode.leftNode == None) {
      node.depth = depth
      parentNode.leftNode = Option(node)
    }
    else if (parentNode.value.headOption.get < node.value && parentNode.rightNode == None){
      node.depth = depth
      parentNode.rightNode = Option(node)
    }
    else if (parentNode.value.headOption.get > node.value && parentNode.leftNode != None)
      setNodePosition(parentNode.leftNode.get, node, depth+1)
    else  if (parentNode.value.headOption.get < node.value && parentNode.rightNode != None)
      setNodePosition(parentNode.rightNode.get, node, depth + 1)
    //else println ("Duplicate node found " + parentNode.value.headOption.get)
  }

   private def printNode(node: TreeNode[T]): Unit = {
    if (node.leftNode != None) {
      printNode(node.leftNode.get)
      print(s"${node.value.head} ${node.depth} | ")
      if (node.rightNode != None)
        printNode(rootNode.rightNode.get)

        /*if (node != rootNode)
           print(s"${node.value.head} (${node.depth})   |     ")
        else if (rootNode.rightNode != None)
           printNode(rootNode.rightNode.get)
         else
           print(s"${node.value.head} (${node.depth})   |     ")
         //if (node == rootNode && node.rightNode != None)
          //print(s"${node.value.head} (${node.depth})") */
     }
   else if (node.rightNode != None) {
        printNode(node.rightNode.get)
        print(s"${node.value.head} (${node.depth})   |     ")
      }
    else if (node.leftNode == None)
        print(s"${node.value.head} (${node.depth})   |     ")
    else if (node.rightNode == None)
        print(s"${node.value.head} (${node.depth})   |     ")
    }

  private def search ( sNode: TreeNode[T], node : TreeNode[T] = rootNode): Boolean = sNode.value.head match {
    case a if node.value.head != a && node.rightNode == None => false
    case a if node.value.head != a && node.leftNode == None => false
    case a if a > List(node.value.head) => search(sNode, node.rightNode.get)
    case a if a < List(node.value.head) => search( sNode, node.leftNode.get)
    case _ => true
  }
}


