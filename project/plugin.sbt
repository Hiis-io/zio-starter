addSbtPlugin("ch.epfl.scala"         % "sbt-bloop"     % "1.4.8")
addSbtPlugin("com.eed3si9n"          % "sbt-unidoc"    % "0.4.3")
addSbtPlugin("com.eed3si9n"          % "sbt-buildinfo" % "0.10.0")
addSbtPlugin("io.github.davidmweber" % "flyway-sbt"    % "6.2.2")
addSbtPlugin("org.scoverage"         % "sbt-scoverage" % "2.0.5")
addSbtPlugin("org.scalameta"         % "sbt-scalafmt"  % "2.4.6")
addSbtPlugin("org.scalameta"         % "sbt-mdoc"      % "2.2.20")
addSbtPlugin("ch.epfl.scala"         % "sbt-scalafix"  % "0.10.1")
addSbtPlugin("se.marcuslonnberg"     % "sbt-docker"    % "1.9.0")
addSbtPlugin("com.eed3si9n"          % "sbt-assembly"  % "1.2.0")

libraryDependencies += "org.snakeyaml" % "snakeyaml-engine" % "2.4"
