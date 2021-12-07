package io.dolcefarniente

import scala.io.Source

object Day7 {

  def solution(crabs: List[Int], f: Int => Int = identity): Int = {
    val m = crabs.max
    (m to 0 by -1).map(i => crabs.map(c => f(math.abs(i-c))).sum).min
  }

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day7")
    val line = try src.getLines().toList.head finally src.close()
    val crabs = line.split(",").map(_.toInt).toList

    println("Day 7")
    println(s"solution 1: ${solution(crabs)}")
    println(s"solution 2: ${solution(crabs, x => (x*(x+1))/2)}")
  }

}
