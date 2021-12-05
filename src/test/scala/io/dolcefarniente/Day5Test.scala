package io.dolcefarniente

import org.scalatest.FunSuite

class Day5Test extends FunSuite {

  test("Day 5 -- getCoords") {
    val coords = Day5.getCoordinates((0,9), (5,9))
    assert(coords == List((0,9), (1,9), (2,9), (3,9), (4,9), (5,9)))
    val reverse = Day5.getCoordinates((5,9), (0,9))
    assert(reverse == List((5,9), (4,9), (3,9), (2,9), (1,9), (0,9)))
    val diag = Day5.getCoordinates((1,1),(3,3))
    assert(diag == List((1,1), (2,2), (3,3)))
    val diag2 = Day5.getCoordinates((9,7), (7,9))
    assert(diag2 == List((9,7), (8,8), (7,9)))
  }

  test("Day 5 -- solution 1") {
    val coordinates = List(((0,9), (5,9)), ((8,0), (0,8)), ((9,4), (3,4)), ((2,2), (2,1)), ((7,0), (7,4)), ((6,4), (2,0)), ((0,9), (2,9)), ((3,4), (1,4)), ((0,0), (8,8)), ((5,5), (8,2)))
    val solution = Day5.solution1(coordinates)
    assert(solution == 5)
  }

  test("Day 5 -- solution 2") {
    val coordinates = List(((0,9), (5,9)), ((8,0), (0,8)), ((9,4), (3,4)), ((2,2), (2,1)), ((7,0), (7,4)), ((6,4), (2,0)), ((0,9), (2,9)), ((3,4), (1,4)), ((0,0), (8,8)), ((5,5), (8,2)))
    val solution = Day5.solution2(coordinates)
    assert(solution == 12)
  }

}
