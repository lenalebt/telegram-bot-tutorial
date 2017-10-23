package de.lenabrueder.telegrambot

object HelloBotHelper {
  def doSomething(text: String) = text match {
    case "/test" => "wow, it really is a test!"
    case other   => other.reverse
  }
}
