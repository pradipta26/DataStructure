package org.pradipta.dataStructure

//import org.pradipta.dataType.MathNode
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
class Graph[T] ( arg : List[String]){
  private case class Vertices (var value : List[String]){
    var edges  = mutable.Map.empty[String, Int]
    var relation : Int = 0
  }
  private val verticesList = for (vert <- arg) yield {Vertices (List(vert))}
  private val verticesMap = Map(verticesList.map{ x => x.value.head -> x} : _*)

  print(verticesMap)

  def addUniRelation (rel : List[(String ,String, Int)]) = {
    rel.foreach( x => {
     // println("key is "+ x._1)
      val currentVertices = verticesMap(x._1)
      currentVertices.edges += x._2 -> 0
      currentVertices.relation += 1
      //println("current edges " + currentVertices.edges  + "(" + currentVertices.relation + ")" )
    })
 }
  import scala.collection.mutable.ListBuffer
  def addBiRelation (rel : List[(String ,String, Int)]) = {
    addUniRelation(rel)
    rel.foreach( x => {
      //println("Value is "+ x._2)
      val currentVertices = verticesMap(x._2)
      if (x._3 == None) currentVertices.edges += x._1 -> 0 else currentVertices.edges += x._1 -> x._3
      currentVertices.relation += 1
      //println("current edges " + currentVertices.edges +"(" + currentVertices.relation + ")" )
    })
  }
  def isPathExist (node1 : String, node2 :String, numberOfPath : Int = 0, searchFound : mutable.ListBuffer[String] = ListBuffer(), link : StringBuffer = new StringBuffer()){
    if (link.length() == 0)
      link.append(node1)
    searchFound += node1
    val vertices1 = verticesMap(node1)
    val currentKeySet = vertices1.edges.keys.toSet -- searchFound
    //println("CurrentKey " + currentKeySet)
    if (currentKeySet.size > 0) {
      if (currentKeySet.contains(node2)) {
        println(s"\n ------------------ \n ${link} -> ${node2}\n-----------------")
        //searchFound += node2
        numberOfPath + 1
      }

      val newKeys = vertices1.edges.keys.toSet -- searchFound
      //println("newKeys " + newKeys)
      if (newKeys.size == 0)
        link.delete(1,link.length())
      newKeys.foreach(x => {
        if (x != node2){
          //println("current Key " + x + " Current Node2 " + node2 + " and searchFound = " +searchFound  +" Keys "+currentKeySet)
          //searchFound += x
          val newNode = verticesMap(x)
          val newInternalKey = (newNode.edges.keys.toSet -- searchFound)
          isPathExist(x, node2, numberOfPath + 1, searchFound, link.append(s"-> $x"))
          //newInternalKey.foreach(y => isPathExist(y, node2, numberOfPath + 1, searchFound))

        }
      })
    }
    /*val currentNode = verticesMap(x)
      val diffSet = verticesMap(x).edges.keys.toSet & vertices1.edges.keys.toSet
      println(s"\n Current Key ${x} This is before If node1=" +  vertices1.edges + " current Node keys " + currentNode.edges.keys + "and Diffset" +diffSet)


      else if ( x != node2 && diffSet.size > 0) {
        println("Intersection " + diffSet)
        println("Hi")
        diffSet.foreach((node => isPathExist(node, node1, numberOfPath)))
      }
    } )
    /*
    println(s"${vertices1.edges.keys} and  ${vertices2.edges.keys}")
    println (node1 + " -> " + node2)
    if (vertices1.edges.contains(node2)) {
      println("Found")
      numberOfPath + 1
    }
    else vertices2.edges.keys.foreach( (node => isPathExist (node2, node, numberOfPath)))*/
    //)
    */

    return numberOfPath
  }



}
