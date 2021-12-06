package io.dolcefarniente

import io.dolcefarniente.Day6.LanternfishIterator
import org.scalatest.FunSuite

class Day6Test extends FunSuite {

  test("LanternfishIterator") {
    val lanternfish = new LanternfishIterator(List(3,4,3,1,2))
    val day18 = lanternfish.take(18).toList.last
    assert(day18 == 26)
  }

  test("After 80 Days") {
    val lanternfish = new LanternfishIterator(List(3,4,3,1,2))
    val day80 = lanternfish.take(80).toList.last
    assert(day80 == 5934)
  }

  test("After 256 Days") {
    val lanternfish = new LanternfishIterator(List(3,4,3,1,2))
    val day256 = lanternfish.take(256).toList.last
    assert(day256 == 26984457539L)
  }

}
