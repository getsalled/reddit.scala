name := "reddit"

version := "0.1"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
)

initialCommands in console := "import com.getsalled.minwage._"
