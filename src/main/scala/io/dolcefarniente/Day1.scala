package io.dolcefarniente

import scala.annotation.tailrec
import scala.io.Source

object Day1 {

  @tailrec
  def solution1(lines: List[Int], c: Int = 0): Int = {
    lines match {
      case _ :: Nil => c
      case h :: n :: t => solution1(n :: t, if (n > h) c+1 else c)
    }

  }

  @tailrec
  def solution2(lines: List[Int], lastSum: Int = 0, count: Int = 0): Int = {
    lines match {
      case _ :: _ :: _ :: Nil => count
      case a :: b :: c :: d => solution2(b::c::d, a+b+c, if(a+b+c>lastSum) count + 1 else count)
    }
  }

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day1")
    val lines = try src.getLines().toList finally src.close()
    val parsed = lines.map(_.toInt)
    println("Day 1")
    println(s"solution 1: ${solution1(parsed)}")
    println(s"solution 2: ${solution2(parsed)}")
  }

}
