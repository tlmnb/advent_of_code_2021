package io.dolcefarniente

import org.scalatest.FunSuite

class Day2Test extends FunSuite {

  test("Day 2 -- solution 1") {
    val solution = Day2.solution1(List(("forward", 5), ("down", 5), ("forward", 8), ("up", 3), ("down", 8), ("forward", 2)))
    assert(solution == 150)
  }

  test("Day 2 -- solution 2") {
    val solution = Day2.solution2(List(("forward", 5), ("down", 5), ("forward", 8), ("up", 3), ("down", 8), ("forward", 2)))
    assert(solution == 900)
  }

}
