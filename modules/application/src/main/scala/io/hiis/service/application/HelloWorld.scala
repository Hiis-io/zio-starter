package io.hiis.service.application

import zio.{ Scope, ZIO, ZIOAppArgs, ZIOAppDefault }

object HelloWorld extends ZIOAppDefault {

  val myAppLogic =
    for {
      console <- ZIO.console
      _       <- console.printLine("Hello! What is your name?")
      name    <- console.readLine
      _       <- console.printLine(s"Hello, $name, welcome to ZIO!")
    } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = myAppLogic
}
