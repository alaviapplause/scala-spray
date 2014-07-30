organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.10.3"

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE17)

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.1.4"
  val sprayV = "1.1.1"
  Seq(
    "io.spray"            %   "spray-can"     % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %   "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV withSources() withJavadoc(),
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2"        % "2.2.3" % "test",
    "org.slf4j"           %   "slf4j-nop"    % "1.6.4",
    "net.fwbrasil" %% "activate-core" % "1.6" withSources() withJavadoc(),
    "net.fwbrasil" %% "activate-jdbc" % "1.6" withSources() withJavadoc(),
    "net.fwbrasil" %% "activate-prevayler" % "1.6" withSources() withJavadoc(),
    "mysql" % "mysql-connector-java" % "5.1.12"
  )
}

Revolver.settings

