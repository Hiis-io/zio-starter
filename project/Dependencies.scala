import sbt._

/** Created by Abanda Ludovic on 19/09/2022 */
object Dependencies {

  private object Versions {
    val zio                     = "2.0.4"
    val zioKafka                = "2.0.1"
    val zioConfig               = "3.0.2"
    val pureConfig              = "0.17.1"
    val zioLogging              = "2.1.1"
    val zioLog4j                = "2.1.1"
    val zioSlick                = "0.5.0"
    val circe                   = "0.14.3"
    val playJson                = "2.9.3"
    val log4j                   = "2.19.0"
    val disruptor               = "3.4.4"
    val kafka                   = "3.3.1"
    val zioInteropCats          = "22.0.0.0"
    val zioResilience           = "0.9.0"
    val ZioHttp                 = "2.0.0-RC9"
    val zioJson                 = "0.3.0-RC10"
    val ZioPrelude              = "1.0.0-RC15"
    val redis                   = "3.42"
    val embeddedRedis           = "0.4.0"
    val reactivemongo           = "1.1.0-RC6"
    val embeddedMongodb         = "3.5.1"
    val postgresSql             = "42.5.0"
    val flyway                  = "9.8.2"
    val slickPostgres           = "0.21.0"
    val slick                   = "3.4.1"
    val scalaTime               = "2.32.0"
    val sttpAuth                = "0.15.2"
    val pbkdf2                  = "0.7.0"
    val jwtCirce                = "9.1.2"
    val organizeImportsVersion  = "0.6.0"
    val tapir                   = "1.2.2"
    val refined                 = "0.10.1"
    val betterMonadicForVersion = "0.3.1"
    val semanticDBVersion       = "4.5.13"
    val kindProjectorVersion    = "0.13.2"
  }

  object Libraries {
    import Versions._

    val zio = Seq(
      "dev.zio"   %% "zio"          % Versions.zio,
      "dev.zio"   %% "zio-streams"  % Versions.zio,
      "dev.zio"   %% "zio-macros"   % Versions.zio,
      "dev.zio"   %% "zio-prelude"  % ZioPrelude,
      "nl.vroste" %% "rezilience"   % zioResilience,
      "dev.zio"   %% "zio-test"     % Versions.zio % Test,
      "dev.zio"   %% "zio-test-sbt" % Versions.zio % Test
    )

    val http = Seq(
      "io.d11" %% "zhttp" % ZioHttp
    )

    val tests = Seq(
      "dev.zio" %% "zio-test"     % Versions.zio % Test,
      "dev.zio" %% "zio-test-sbt" % Versions.zio % Test
    )

    val integrationTest = Seq(
      "dev.zio" %% "zio-test"     % Versions.zio % "it,test",
      "dev.zio" %% "zio-test-sbt" % Versions.zio % "it,test"
    )

    val tapir = Seq(
      "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server"   % Versions.tapir,
      "com.softwaremill.sttp.tapir" %% "tapir-sttp-stub-server"  % Versions.tapir,
      "com.softwaremill.sttp.tapir" %% "tapir-sttp-mock-server"  % Versions.tapir,
      "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % Versions.tapir
    )

    val kafka = Seq(
      "dev.zio"                 %% "zio-kafka"      % zioKafka,
      "io.github.embeddedkafka" %% "embedded-kafka" % Versions.kafka % Test
    )

    val zioConfig = Seq(
      "dev.zio" %% "zio-config"          % Versions.zioConfig,
      "dev.zio" %% "zio-config-typesafe" % Versions.zioConfig,
      "dev.zio" %% "zio-config-magnolia" % Versions.zioConfig
    )

    val logging = Seq(
      "dev.zio"                 %% "zio-logging"       % zioLogging,
      "dev.zio"                 %% "zio-logging-slf4j" % zioLog4j,
      "org.apache.logging.log4j" % "log4j-core"        % log4j,
      "org.apache.logging.log4j" % "log4j-slf4j-impl"  % log4j,
      "com.lmax"                 % "disruptor"         % disruptor
    )

    val json = Seq(
      "io.circe"                    %% "circe-core"       % circe,
      "io.circe"                    %% "circe-generic"    % circe,
      "io.circe"                    %% "circe-parser"     % circe,
      "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % Versions.tapir,
      "com.softwaremill.sttp.tapir" %% "tapir-json-zio"   % Versions.tapir,
      "dev.zio"                     %% "zio-json"         % zioJson,
      "com.typesafe.play"           %% "play-json"        % playJson,
      "com.softwaremill.sttp.tapir" %% "tapir-json-play"  % Versions.tapir
    )

    val mongodb = Seq(
      "org.reactivemongo"  %% "reactivemongo"             % reactivemongo,
      "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % embeddedMongodb % Test
    )

    val postgresql = Seq(
      "org.postgresql"       % "postgresql"        % postgresSql,
      "com.github.tminglei" %% "slick-pg"          % slickPostgres,
      "org.flywaydb"         % "flyway-core"       % flyway,
      "io.scalac"           %% "zio-slick-interop" % zioSlick,
      "com.typesafe.slick"  %% "slick-hikaricp"    % slick
    )

    val redis = Seq(
      "net.debasishg"      %% "redisclient"              % Versions.redis,
      "com.github.sebruck" %% "scalatest-embedded-redis" % embeddedRedis % Test
    )

    val auth = Seq(
      "com.github.jwt-scala" %% "jwt-circe"    % jwtCirce,
      "com.ocadotechnology"  %% "sttp-oauth2"  % sttpAuth,
      "io.github.nremond"    %% "pbkdf2-scala" % pbkdf2
    )

    val refined = Seq(
      "eu.timepit" %% "refined"           % Versions.refined,
      "eu.timepit" %% "refined-cats"      % Versions.refined,
      "eu.timepit" %% "refined-shapeless" % Versions.refined
    )

    val compilerPlugins = Seq(
      compilerPlugin(
        "com.olegpy" %% "better-monadic-for" % betterMonadicForVersion
      ),
      compilerPlugin(
        "org.typelevel" %% "kind-projector" % kindProjectorVersion cross CrossVersion.full
      ),
      compilerPlugin(
        "org.scalameta" % "semanticdb-scalac" % semanticDBVersion cross CrossVersion.full
      )
    )

    val cats = Seq("dev.zio" %% "zio-interop-cats" % zioInteropCats)

    val twillo = Seq("com.twilio.sdk" % "twilio" % "9.1.3")

    val mail = Seq("org.apache.commons" % "commons-email" % "1.5")

    // Scalafix rules
    val organizeImports = "com.github.liancheng" %% "organize-imports" % organizeImportsVersion
  }
}
