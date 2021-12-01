package io.dolcefarniente

import org.scalatest.FunSuite

class Day1Test extends FunSuite {

  test("day 1 -- solution 1") {
    val solution1 = Day1.solution1(List(199, 200, 208, 210, 200, 207, 240, 269, 260, 263))
    assert(solution1 == 7)

    val solution1Alternative = Day1.solution1Alternative(List(199, 200, 208, 210, 200, 207, 240, 269, 260, 263))
    assert(solution1Alternative == 7)
  }

  test("day 1 -- solution 2") {
    val solution = Day1.solution2(List(607, 618, 618, 617, 647, 716, 769, 792))
    assert(solution == 5)

    val solution2Alternative = Day1.solution2Alternative(List(607, 618, 618, 617, 647, 716, 769, 792))
    assert(solution2Alternative == 5)
  }

}
