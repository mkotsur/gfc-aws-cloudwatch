name := "gfc-aws-cloudwatch"

organization := "com.gilt"

scalaVersion := "2.11.11"

crossScalaVersions := Seq(scalaVersion.value, "2.12.3")

val awsLibVersion = "1.11.78"

scalacOptions += "-target:jvm-1.7"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

libraryDependencies ++= Seq(
  "com.gilt" %% "gfc-logging" % "0.0.8"
, "com.gilt" %% "gfc-concurrent" % "0.3.5"
, "com.amazonaws" % "aws-java-sdk-cloudwatch" % awsLibVersion
, "com.amazonaws" % "aws-java-sdk-logs" % awsLibVersion
, "org.specs2" %% "specs2-scalacheck" % "3.8.6" % Test
)

releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache-style" -> url("https://raw.githubusercontent.com/gilt/gfc-aws-cloudwatch/master/LICENSE"))

homepage := Some(url("https://github.com/gilt/gfc-aws-cloudwatch"))

pomExtra := <scm>
  <url>https://github.com/gilt/gfc-aws-cloudwatch.git</url>
  <connection>scm:git:git@github.com:gilt/gfc-aws-cloudwatch.git</connection>
</scm>
<developers>
  <developer>
    <id>gheine</id>
    <name>Gregor Heine</name>
    <url>https://github.com/gheine</url>
  </developer>
  <developer>
    <id>andreyk0</id>
    <name>Andrey Kartashov</name>
    <url>https://github.com/andreyk0</url>
  </developer>
</developers>

