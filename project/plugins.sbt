// comment to get more information during initialization
logLevel := Level.Warn

// gatling perforamce test
addSbtPlugin("io.gatling" % "gatling-sbt" % "2.2.0")

// shows sbt project dependency updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.8")

libraryDependencies += "com.trueaccord.scalapb" %% "compilerplugin" % "0.5.47"

