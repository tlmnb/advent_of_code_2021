package io.dolcefarniente

import scala.io.Source

object Day5 {

  def getCoordinates(p1: (Int, Int), p2: (Int, Int)): List[(Int, Int)] = {
    if (p1._1 == p2._1) {
      Range.inclusive(p1._2, p2._2, if(p1._2<p2._2) 1 else -1)
        .map(p => (p1._1, p)).toList
    } else if(p1._2 == p2._2) {
      Range.inclusive(p1._1, p2._1, if(p1._1<p2._1) 1 else -1)
        .map(p => (p, p1._2)).toList
    } else if(Math.abs(p1._1 - p2._1) == Math.abs(p1._2 - p2._2)) {
      val x = Range.inclusive(p1._1, p2._1, if(p1._1<p2._1) 1 else -1)
      val y = Range.inclusive(p1._2, p2._2, if(p1._2<p2._2) 1 else -1)
      x.zip(y).toList
    } else {
      throw new IllegalArgumentException("cannot create horizontal, vertical or diagonal line")
    }
  }

  def parseLines(lines: List[String]): List[((Int, Int), (Int, Int))] = {
      lines.map(
        l => l.split(" -> ")
      ).map(
        l => (l(0).split(","), l(1).split(","))
      ).map(
        l => ((l._1(0).toInt, l._1(1).toInt), (l._2(0).toInt, l._2(1).toInt))
      )
  }

  def solution(coordinates: List[((Int, Int), (Int, Int))]): Int = {
    coordinates
      .flatMap(t => getCoordinates(t._1, t._2))
      .groupMapReduce(identity)(_ => 1)(_ + _)
      .count(t => t._2 > 1)
  }


  def solution1(coordinates: List[((Int, Int), (Int, Int))]): Int =
    solution(coordinates
      .filter(p => p._1._1 == p._2._1 || p._1._2 == p._2._2 ))


  def solution2(coordinates: List[((Int, Int), (Int, Int))]): Int =
    solution(coordinates
      .filter(p => p._1._1 == p._2._1 || p._1._2 == p._2._2|| Math.abs(p._1._1 - p._2._1) == Math.abs(p._1._2 - p._2._2)))


  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day5")
    val lines = try src.getLines().toList finally src.close()
    val coordinates = parseLines(lines)

    println("Day 5")
    println(s"solution 1: ${solution(coordinates)}")
    println(s"solution 2: ${solution(coordinates)}")
  }



}
