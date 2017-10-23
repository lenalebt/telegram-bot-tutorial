package de.lenabrueder.telegrambot

import info.mukel.telegrambot4s.api.declarative.{Commands, InlineQueries}
import info.mukel.telegrambot4s.api.{ChatActions, Polling, TelegramBot}
import info.mukel.telegrambot4s.methods.SendMessage
import info.mukel.telegrambot4s.models._

class HelloBot(val token: String) extends TelegramBot with Polling with Commands with ChatActions with InlineQueries {

  //TODO: create base trait for TelegramBot with Polling!

  override def receiveMessage(msg: Message): Unit = {
    for (text <- msg.text)
      request(SendMessage(msg.source, HelloBotHelper.doSomething(text)))
  }

  //onCommand("/test") { implicit msg =>
  //  reply("Yep, that is a test.")
  //}
}
