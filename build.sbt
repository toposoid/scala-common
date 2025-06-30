import Dependencies._
import sbt.Keys.libraryDependencies
import de.heikoseeberger.sbtheader.License

ThisBuild / scalaVersion     := "2.13.11"
ThisBuild / version          := "0.6-SNAPSHOT"
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
licenses += ("AGPL-3.0-or-later", new URL("http://www.gnu.org/licenses/agpl-3.0.en.html"))
headerLicense := Some(License.AGPLv3("2025", organizationName.value))

