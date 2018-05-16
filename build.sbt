name := """play-boilerplate"""
organization := "com.raha"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

val playVersion = "2.6.13"
val playPac4jVersion = "6.0.0-RC1"
val pac4jVersion = "3.0.0-RC1"

resolvers ++= Seq(Resolver.mavenLocal, "Sonatype snapshots repository" at "https://oss.sonatype.org/content/repositories/snapshots/")

libraryDependencies ++= Seq(
  guice,
  ehcache, // or cacheApi
  ws,
  filters,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  "org.pac4j" %% "play-pac4j" % playPac4jVersion,
  "org.pac4j" % "pac4j-http" % pac4jVersion,
  "org.pac4j" % "pac4j-cas" % pac4jVersion,
  "org.pac4j" % "pac4j-openid" % pac4jVersion exclude("xml-apis", "xml-apis"),
  "org.pac4j" % "pac4j-oauth" % pac4jVersion,
//  "org.pac4j" % "pac4j-saml" % pac4jVersion,
  "org.pac4j" % "pac4j-oidc" % pac4jVersion exclude("commons-io", "commons-io"),
  "org.pac4j" % "pac4j-gae" % pac4jVersion,
  "org.pac4j" % "pac4j-jwt" % pac4jVersion exclude("commons-io", "commons-io"),
  "org.pac4j" % "pac4j-ldap" % pac4jVersion,
  "org.pac4j" % "pac4j-sql" % pac4jVersion,
  "org.pac4j" % "pac4j-mongo" % pac4jVersion,
  "org.pac4j" % "pac4j-kerberos" % pac4jVersion,
  "org.pac4j" % "pac4j-couch" % pac4jVersion,
  "com.typesafe.play" %% "play-cache" % playVersion,
  "commons-io" % "commons-io" % "2.5"
)


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.raha.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.raha.binders._"
