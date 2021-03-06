import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "PlayBars2a"
    val appVersion      = "1.0"

     val postgresql = "postgresql" % "postgresql" % "9.0-801.jdbc3"

  ebeanEnabled := true

    val appDependencies = Seq(
      // Add your project dependencies here,
      postgresql
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here
      resolvers ++= Seq(DefaultMavenRepository,
        Resolver.url("Play", url("https://playframework2.ci.cloudbees.com/job/play2-integrationtest/ws/repository/local/"))
          (Resolver.ivyStylePatterns), "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/")
    )

}
