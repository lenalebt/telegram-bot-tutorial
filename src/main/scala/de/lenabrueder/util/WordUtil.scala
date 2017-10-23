package de.lenabrueder.util

class WordUtil {
  def countChars(text: String) = text.length
  def words(text: String)      = text.split("\\W+").toList
  def countWords(text: String) = words(text).length
  def countWordOccurrences(text: String) = words(text).foldLeft(Map.empty[String, Int]) { (count, word) =>
    count + (word -> (count.getOrElse(word, 0) + 1))
  }
}
