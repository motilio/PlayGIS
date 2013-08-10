import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "PlayGISJava"
  val appVersion      = "0.1"

  val appDependencies = Seq(
      javaCore,
      javaJdbc,
      javaJpa,
      "org.hibernate" % "hibernate-entitymanager" % "4.2.2.Final",
      "com.google.inject" % "guice" % "3.0"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // disable Ebean ORM
    ebeanEnabled := false,
    scalaVersion := "2.10.2"
  )

}
