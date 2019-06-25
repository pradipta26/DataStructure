package org.pradipta.dataStructure

 class LinkedList[A]{
    private var head : Node[A] = _
    private class Node[A](elem: A){
      var value : A = elem
      var nextNode : Node[A] = _
    }
    def addNode(value: A): Unit ={
      val node = new Node[A](value)
      if (head == null) head = node
      else {
        node.nextNode = head
        head = node
      }
    }
    private def showNode (node : Node[A]) : Unit = {
      if (node != null) {
        print (s"${node.value} ->")
        showNode(node.nextNode)
      }
    }
    def showAll()=  showNode(head)
  }
