package org.pradipta.dataStructure

object CoinProblemGoogle {
  var totalCount = 0

  def checkCoinOptions(count : Int, coins: List[Int]): Int = {
    for (x <- coins){
      if(count % x == 0) totalCount+=1
      calculateCount(count, x, coins.tail )
    }
    totalCount
  }

  private def calculateCount (count : Int, currentCoin : Int, coinsList: List[Int]): Unit = {
    if (coinsList.size > 0){
      for( x <- coinsList){
        println(s" Coins = $x")
        sum(currentCoin, x, count)
      }
    }
  }
  def sum (i : Int, j : Int, count : Int, currentCount : Int = 0): Unit ={

    if(currentCount + j < count) {
      println(s"Hello currentCount = $currentCount + $j and $i ")
      sum(i, j, count, currentCount + i)
      sum(j, i, count,currentCount + j)
    }
    else if(currentCount + j == count) {
        println(s"Total Count -> $count = $currentCount + $j and total count $totalCount")
        totalCount += 1
      }
      else if (currentCount + j > count) println(s"Hi I am extra $currentCount + $j}")

  }
  }


