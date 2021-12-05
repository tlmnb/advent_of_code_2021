package io.dolcefarniente

import scala.annotation.tailrec
import scala.io.Source

object Day2 {

  @tailrec
  def solution1(commands: List[(String, Int)], horizontal: Int = 0, depth: Int = 0): Int = {
    commands match {
      case ("forward", arg)::t => solution1(t, horizontal+arg, depth)
      case ("down", arg)::t => solution1(t, horizontal, depth+arg)
      case ("up", arg)::t => solution1(t, horizontal, depth-arg)
      case Nil => horizontal * depth
    }
  }

  @tailrec
  def solution2(commands: List[(String, Int)], horizontal: Int = 0, depth: Int = 0, aim: Int = 0): Int = {
    commands match {
      case ("forward", arg)::t => solution2(t, horizontal+arg, depth + arg*aim, aim)
      case ("down", arg)::t => solution2(t, horizontal, depth, aim+arg)
      case ("up", arg)::t => solution2(t, horizontal, depth, aim-arg)
      case Nil => horizontal * depth
    }
  }

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day2")
    val lines = try src.getLines().toList finally src.close()
    val parsed = lines.map(_.split(" ")).map(a => (a(0), a(1).toInt))
    println("Day 2")
    println(s"solution 1: ${solution1(parsed)}")
    println(s"solution 2: ${solution2(parsed)}")
  }

}
