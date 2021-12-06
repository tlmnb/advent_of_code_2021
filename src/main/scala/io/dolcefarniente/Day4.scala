package io.dolcefarniente

import scala.annotation.tailrec
import scala.io.Source

object Day4 {


  class Bingo(private val rows: List[List[(Int, Boolean)]], private val columns: List[List[(Int, Boolean)]]) {

    def this(numbers: List[List[Int]]) = {
      this(numbers.map(l => l.map((_, false))), numbers.map(l => l.map((_, false))).transpose)
    }

    def +(n: Int): Bingo = {
      val nr = rows.map(r => r.map(t => (t._1, if(!t._2 && t._1 == n) true else t._2)))
      val nc = columns.map(r => r.map(t => (t._1, if(!t._2 && t._1 == n) true else t._2)))
      new Bingo(
        nr,
        nc
      )
    }

    def bingo(): Boolean = {
      rows.exists(_.forall(r => r._2)) || columns.exists(_.forall(c => c._2))
    }

    def score(): Int = {
      rows.flatMap(r => r.filter(!_._2).map(_._1)).sum
    }

  }


  @tailrec
  def solution1(numbers: List[Int], grids: List[Bingo]): Int = {
    numbers match {
      case h::t => {
        val updated = grids.map(_ + h)
        val bingo = updated.find(b => b.bingo())
        if(bingo.isDefined) {
          bingo.get.score() * h
        } else {
          solution1(t, updated)
        }
      }
      case Nil => throw new IllegalStateException("no bingo")
    }

  }

  @tailrec
  def solution2(numbers: List[Int], grids: List[Bingo]): Int = {
    numbers match {
      case h::t => {
        val updated = grids.map(_ + h)
        if(updated.size > 1) {
          val filtered = updated.filter(b => !b.bingo())
          solution2(t, filtered)
        } else {
          if(updated.head.bingo()) {
            updated.head.score() * h
          } else {
            solution1(t, updated)
          }
        }
      }
      case Nil => throw new IllegalStateException("no bingo")
    }


  }

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day4")
    val lines = try src.getLines().toList finally src.close()

    val numbers = lines.head.split(",").map(_.toInt).toList
    val grids = lines.drop(1).sliding(6, 6)
      .map(l => l.filter(_.nonEmpty)
        .map(_.split(" ").toList.filter(_.nonEmpty).map(_.toInt)))
      .map(new Bingo(_)).toList

    println("Day 4")
    println(s"solution 1: ${solution1(numbers, grids)}")
    println(s"solution 2: ${solution2(numbers, grids)}")
  }

}
