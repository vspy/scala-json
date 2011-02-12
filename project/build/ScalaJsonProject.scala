import sbt._

class ScalaJsonProject(info: ProjectInfo) extends DefaultProject(info) {
  val specs = buildScalaVersion match {
    case "2.7.7" => "org.scala-tools.testing" % "specs" % "1.6.2.1" % "test"
    case _ =>       "org.scala-tools.testing" % "specs_2.8.1" % "1.6.6" % "test"
  }

  override def disableCrossPaths = false

  override def compileOptions = super.compileOptions ++ Seq(Unchecked) ++
    compileOptions("-encoding", "utf8")

  override def pomExtra =
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
      <license>
        <name>Scala License</name>
        <url>http://www.scala-lang.org/node/146</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
}
