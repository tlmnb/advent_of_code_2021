package io.dolcefarniente

import org.scalatest.FunSuite

class Day7Test extends FunSuite {

  test("Day7 -- solution 1") {
    val leastFuel = Day7.solution(List(16,1,2,0,4,2,7,1,2,14))
    assert(leastFuel == 37)
  }

  test("Day 7 -- solution 2") {
    val leastFuel = Day7.solution(List(16,1,2,0,4,2,7,1,2,14), x => (x*(x+1))/2)
    assert(leastFuel == 168)
  }

}
