import Dependencies._

lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

lazy val root: Project = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version := "0.1.0-SNAPSHOT"
    )),
  name := "TelegramBotTutorial",
  scapegoatVersion in ThisBuild := "1.3.3",
  libraryDependencies += scalaTest % Test,
  libraryDependencies ++= Seq(
    "info.mukel" %% "telegrambot4s" % "3.0.13"
  ),
  scalafmtVersion := "1.3.0",
  scalafmtOnCompile in ThisBuild := true,
  compileScalastyle := scalastyle.in(Compile).toTask("").value,
  (compile in Compile) := ((compile in Compile) dependsOn compileScalastyle).value
)
