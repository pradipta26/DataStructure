package org.pradipta.dataStructure

object SwapLetter {
  var charSwapFound = false
  def swapLetterCheck(arg0 : String, arg1 : String ) : Boolean = {
    var found = false
    val length = arg0.size - 2
    for ( x <- 0 to length){
      val searchString = arg0(x + 1).toString.concat(arg0(x).toString)
      if(arg1.contains(searchString)) found = true
    }
    found
  }
  def checkLetterSwap (arg0 : String, arg1 : String ) : Boolean = {
    val result = swapAnywhereCheck(arg0,arg1)
    charSwapFound = false
    result
  }
  private def swapAnywhereCheck (arg0 : String, arg1 : String , found : Boolean = false) : Boolean = {
    if (charSwapFound == false) {
      var isFound = found
      //println(s"isFound = $isFound")
      if (arg0.size > 0 && arg1.size > 0) {
        val arg0Length = arg0.size
        val firstString = arg0.substring(1, arg0Length).toLowerCase
        val secondString = arg1.toLowerCase

        for (i <- 0 to (arg0Length - 2)) {
          if (charSwapFound == false) {
            //println(s"arg0Length ${arg0Length}")
            val currentChar = firstString(i).toString
           // println(s"First String = $firstString and Second String = $secondString CurrentString = $currentChar")
            if (secondString.contains(currentChar) && isFound == true) charSwapFound = true
            else if (secondString.contains(currentChar) && isFound == false)
              swapAnywhereCheck(firstString.substring(i), secondString.substring(0, secondString.indexOf(currentChar) + 1), true)
          }
        }

      }
    }
      //println(s"isFound = $charSwapFound")
    charSwapFound
    }

  }

