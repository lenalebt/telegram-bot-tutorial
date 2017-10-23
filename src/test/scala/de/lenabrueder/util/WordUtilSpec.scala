package de.lenabrueder.util

import spec.UnitSpec

class WordUtilSpec extends UnitSpec {
  val wordUtil = new WordUtil

  "Counting characters in a text" should "work with unicode chars" in {
    assert(wordUtil.countChars("öäü") == 3)
  }
  it should "work with normal characters" in {
    assert(wordUtil.countChars("abcdefghijklmnopqrstuvwxyz") == 26)
  }

  "Counting words" should "not count double spaces" in {
    assert(wordUtil.countWords("this is a  test") == 4)
  }
  it should "correctly count normal sentences" in pending

  "Counting the occurrences for any single word" should "return a map of words and counts" in pending
  it should "not contain any words that have not been in the original sentence" in pending
}
