name := "debugview-client-scala"

version := "0.0.1-SNAPSHOT"

organization := "me.yuhuan"

scalaVersion := "2.11.7"

publishMavenStyle := true

isSnapshot := true

scalacOptions in (Compile, doc) += "-diagrams"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "me.tongfei" %% "poly-util" % "0.2.3-SNAPSHOT"
libraryDependencies += "me.yuhuan" %% "yutil" % "0.0.2-SNAPSHOT"

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomExtra :=
  <url>https://github.com/jyuhuan/debugview-client-scala</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>http://opensource.org/licenses/MIT</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:jyuhuan/debugview-client-scala.git</url>
      <connection>scm:git:git@github.com:jyuhuan/debugview-client-scala.git</connection>
    </scm>
    <developers>
      <developer>
        <id>yuhuan</id>
        <name>Yuhuan Jiang</name>
        <url>http://yuhuan.me/</url>
      </developer>
    </developers>

