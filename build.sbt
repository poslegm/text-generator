lazy val root = (project in file("."))
  .settings(
    organization := "com.github.poslegm",
    name := "kittens-text-generator",
    version := "0.0.1",
    scalaVersion := "2.12.6",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:higherKinds")
  )

