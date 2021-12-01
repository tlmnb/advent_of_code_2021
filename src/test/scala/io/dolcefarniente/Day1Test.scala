package io.dolcefarniente

import org.scalatest.FunSuite

class Day1Test extends FunSuite {

  test("day 1 -- solution 1") {
    val solution = Day1.solution1(List(199, 200, 208, 210, 200, 207, 240, 269, 260, 263))
    assert(solution == 7)
  }

  test("day 1 -- solution 2") {
    val solution = Day1.solution2(List(607, 618, 618, 617, 647, 716, 769, 792))
    assert(solution == 5)
  }

}
