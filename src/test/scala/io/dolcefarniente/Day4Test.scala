package io.dolcefarniente


import io.dolcefarniente.Day4.Bingo
import org.scalatest.FunSuite

class Day4Test extends FunSuite {

  test("Day 4 -- solution 1") {
    val numbers = List(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1)
    val boards = List(
      List(
        List(14, 21, 17, 24, 4),
        List(10, 16, 15, 9, 19),
        List(18, 8, 23, 26, 20),
        List(22, 11, 13, 6, 5),
        List(2, 0, 12, 3 , 7)
      )
    ).map(new Bingo(_))
    val solution = Day4.solution1(numbers, boards)
    assert(solution == 4512)
  }

  test("Day4 -- solution 2") {
    val numbers = List(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1)
    val boards = List(
      List(
        List(14, 21, 17, 24, 4),
        List(10, 16, 15, 9, 19),
        List(18, 8, 23, 26, 20),
        List(22, 11, 13, 6, 5),
        List(2, 0, 12, 3 , 7)
      ),
      List(
        List(3, 15, 0, 2, 22),
        List(9, 18, 13, 17, 5),
        List(19, 8, 7, 25, 23),
        List(20, 11, 10, 24, 4),
        List(14, 21, 16, 12, 6)
      ),
      List(
        List(14, 21, 17, 24, 4),
        List(10, 16, 15, 9, 19),
        List(18, 8, 23, 26, 20),
        List(22, 11, 13, 6, 5),
        List(2, 0, 12, 3, 7)
      )
    ).map(new Bingo(_))

    val solution = Day4.solution2(numbers, boards)
    assert(solution == 1924)
  }

}
