package io.dolcefarniente

import scala.annotation.tailrec
import scala.io.Source

object Day3 {

  def mostCommonBits(report: List[String]): List[(Int, Int)] = {

    @tailrec
    def apply(report: List[String], bitCount: List[(Int, Int)] = List()): List[(Int, Int)] = {
      report match {
        case h::t =>
          val bits = h.map {
            case '0' => (1, 0)
            case '1' => (0, 1)
          }.toList

          apply(t, bitCount
            .zipAll(bits, (0, 0), (0, 0))
            .map(a => (a._1._1 + a._2._1 , a._1._2 + a._2._2)))
        case Nil =>
          bitCount
      }
    }

    apply(report)
  }


  def solution1(report: List[String]): Int = {
    val bits = mostCommonBits(report)
    val gamma = Integer.parseInt(bits.map(t => if(t._1 > t._2) "0" else "1").mkString, 2)
    val epsilon = Integer.parseInt(bits.map(t => if(t._1 > t._2) "1" else "0").mkString, 2)
    gamma * epsilon
  }

  def solution2(report: List[String]): Int = {

    @tailrec
    def search(report: List[String], f: ((Int, Int)) => Char, pos: Int = 0): String = {
      if (report.size == 1) {
        report.head
      } else {
        val mostCommonBit = mostCommonBits(report.map(s => s.charAt(pos).toString)).map(f).head
        search(report.filter(s => s.charAt(pos) == mostCommonBit), f, pos+1)
      }
    }

    val oxygen = search(report, t => if(t._2 >= t._1) '1' else '0')
    val o2 = Integer.parseInt(oxygen, 2)

    val carbonDioxide = search(report, t => if(t._1 <= t._2) '0' else '1')
    val co2 = Integer.parseInt(carbonDioxide, 2)
    co2 * o2
  }

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day3")
    val lines = try src.getLines().toList finally src.close()

    println("Day 3")
    println(s"solution 1: ${solution1(lines)}")
    println(s"solution 2: ${solution2(lines)}")
  }


}
