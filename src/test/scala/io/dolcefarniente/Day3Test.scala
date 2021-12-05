package io.dolcefarniente

import org.scalatest.FunSuite

class Day3Test extends FunSuite {

  test("Day 3 -- solution 1") {
    val solution = Day3.solution1(List("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"))
    assert(solution == 198)
  }

  test("Day 3 -- solution 2") {
    val solution = Day3.solution2(List("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"))
    assert(solution == 230)
  }
}
