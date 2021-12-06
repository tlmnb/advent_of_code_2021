package io.dolcefarniente

import scala.collection.{AbstractIterator, mutable}
import scala.io.Source

object Day6 {

  class LanternfishIterator(private val init: List[Int]) extends AbstractIterator[Long] {

    private val fish = init.foldLeft(mutable.Queue.fill(9){0L})((q,v) => {
      q(v)+=1L
      q
    })

    override def hasNext: Boolean = true

    override def next(): Long = {
      val first = fish.dequeue
      if(first > 0) {
        fish(6) += first
        fish.enqueue(first)
      } else {
        fish.enqueue(0)
      }
      fish.sum
    }
  }

  def solution1(init: List[Int]): Long = {
    new LanternfishIterator(init).take(80).toList.last
  }

  def solution2(init: List[Int]): Long = {
    new LanternfishIterator(init).take(256).toList.last
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
