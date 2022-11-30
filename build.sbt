import Dependencies.Libraries._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / organization     := "io.hiis"
ThisBuild / organizationName := "hiis"

val applicationName    = "zio-starter"
val applicationVersion = "0.0.1"
val dockerUser         = "abanda"

lazy val root = project
  .in(file("."))
  .settings(
    commonSettings,
    dockerSettings,
    name               := applicationName,
    version            := applicationVersion,
    evictionErrorLevel := Level.Warn,
    semanticdbEnabled  := true,
    semanticdbVersion  := scalafixSemanticdb.revision
  )
  .enablePlugins(DockerPlugin, ScalaUnidocPlugin)
  .disablePlugins(sbtassembly.AssemblyPlugin)
  .aggregate(
    application,
    it
  )

lazy val application = project
  .in(file("modules/application"))
  .settings(
    commonSettings,
    consoleSettings,
    name := "application",
    assemblySettings,
    libraryDependencies ++=
      zio ++ tests // Add all common library dependencies here. Have a look at Dependencies object
  )

lazy val it = (project in file("modules/it"))
  .configs(IntegrationTest)
  .disablePlugins(sbtassembly.AssemblyPlugin)
  .settings(
    commonSettings,
    consoleSettings,
    name := "integration-test",
    Defaults.itSettings,
    libraryDependencies ++= integrationTest
  )
  .dependsOn(application % "it->test")

lazy val commonSettings = Seq(
  scalafmtOnCompile := true,
  scalacOptions ++= compilerOptions,
  semanticdbEnabled := true,
  semanticdbVersion := scalafixSemanticdb.revision,
  scalafixDependencies.withRank(KeyRanks.Invisible) += organizeImports,
  testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
  resolvers ++= Resolver.sonatypeOssRepos("snapshots")
)

lazy val consoleSettings = Seq(
  Compile / console / scalacOptions --= Seq("-Ywarn-unused", "-Ywarn-unused-import")
)

lazy val compilerOptions = Seq(
  "-unchecked",
  "-deprecation",
  "-encoding",
  "utf8",
  "-target:jvm-1.8",
  "-feature",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps",
  "-Ywarn-value-discard",
  "-Ymacro-annotations",
  "-Ywarn-unused:imports"
)

lazy val assemblySettings = Seq(
  assembly / assemblyJarName := applicationName + ".jar",
  assembly / assemblyMergeStrategy := {
    case PathList("META-INF", ps @ _*) =>
      if (ps.map(_.toLowerCase).exists(a => a.contains("swagger-ui") || a.contains("log4j")))
        MergeStrategy.singleOrError
      else MergeStrategy.discard
    case x if x.endsWith("module-info.class") => MergeStrategy.discard
    case _                                    => MergeStrategy.first
  }
)

lazy val dockerSettings = Seq(
  docker / dockerfile := NativeDockerfile(file("Dockerfile")),
  docker / imageNames := Seq(ImageName(s"$dockerUser/$applicationName:$applicationVersion")),
  docker / dockerBuildArguments := dockerBuildArgs
)

def dockerBuildArgs: Map[String, String] = sys.env.foldLeft(Map.empty[String, String]) {
  case (acc, (k, v)) =>
    if (Set("UPX_COMPRESSION", "PRINT_REPORTS").contains(k)) acc + (k.toLowerCase -> v) else acc
}

lazy val docs = project
  .in(file("zio-starter-docs"))
  .settings(
    publish / skip := true,
    moduleName     := "zio-starter-docs",
    scalacOptions -= "-Yno-imports",
    scalacOptions -= "-Xfatal-warnings",
    ScalaUnidoc / unidoc / unidocProjectFilter := inProjects(application),
    ScalaUnidoc / unidoc / target := (LocalRootProject / baseDirectory).value / "website" / "static" / "api",
    cleanFiles += (ScalaUnidoc / unidoc / target).value,
    docusaurusCreateSite     := docusaurusCreateSite.dependsOn(Compile / unidoc).value,
    docusaurusPublishGhpages := docusaurusPublishGhpages.dependsOn(Compile / unidoc).value
  )
  .dependsOn(application)
  .enablePlugins(MdocPlugin, DocusaurusPlugin, ScalaUnidocPlugin)

addCommandAlias("build", ";clean; compile; test; assembly;")
addCommandAlias("build-docker", ";clean; compile; test; assembly; docker;")
