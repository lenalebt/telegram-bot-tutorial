package example

import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.LazyLogging
import de.lenabrueder.telegrambot.HelloBot

import scala.concurrent.Future
import scala.io.StdIn
import scala.concurrent.ExecutionContext.Implicits.global

object Hello extends LazyLogging {
  lazy val conf: Config = ConfigFactory.load()

  def main(args: Array[String]): Unit = {
    val bot = new HelloBot(conf.getString("bot.token"))

    logger.info("starting telegram bot...")
    val botRunner = Future(bot.run())

    StdIn.readLine()
    logger.info("shutting down system...")
    bot.shutdown()
  }
}
