import Dependencies._
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.12.12"
ThisBuild / version          := "0.4-SNAPSHOT"
ThisBuild / organization     := "com.ideal.linked"
ThisBuild / organizationName := "common"

lazy val root = (project in file("."))
  .settings(
    name := "scala-common",
    libraryDependencies += "com.typesafe" % "config" % "1.4.1",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.3",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "tech.units" % "indriya" % "2.0.4",
  )
  .enablePlugins(AutomateHeaderPlugin)

organizationName := "Linked Ideal LLC.[https://linked-ideal.com/]"
startYear := Some(2021)
licenses += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt"))
