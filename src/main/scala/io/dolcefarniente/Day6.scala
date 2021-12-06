package io.dolcefarniente

import scala.collection.{AbstractIterator, mutable}
import scala.io.Source

object Day6 {

  class LanternFishIterator(private val init: List[Int]) extends AbstractIterator[Long] {

    private val fish = init.foldLeft(mutable.Queue.fill(9){0L})((q,v) => {
      q(v)+=1L
      q
    })

    override def hasNext: Boolean = true

    override def next(): Long = {
      fish.dequeue match {
        case 0 =>
          fish.enqueue(0)
        case f =>
          fish(6) += f
          fish.enqueue(f)
      }
      fish.sum
    }
  }

  def solution1(init: List[Int]): Long = {
    new LanternFishIterator(init).take(80).toList.last
  }

  def solution2(init: List[Int]): Long = {
    new LanternFishIterator(init).take(256).toList.last
  }

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day6")
    val line = try src.getLines().toList.head finally src.close()
    val initState = line.split(",").map(_.toInt).toList

    println("Day 6")
    println(s"solution 1: ${solution1(initState)}")
    println(s"solution 2: ${solution2(initState)}")
  }

}
