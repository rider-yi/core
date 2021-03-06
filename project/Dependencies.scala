import sbt._

object Dependencies {

  object Versions {
    val CatsEffect  = "0.8"
    val Fs2         = "0.10.0-RC1"
    val Http4s      = "0.18.0-M8"
    val Tsec        = "0.0.1-M7"
    val Circe       = "0.9.0"
    val Doobie      = "0.5.0-M13"
    val H2          = "1.4.196"
    val Flyway      = "5.0.5"
    val Scraper     = "2.0.0"
    val ScalaTest   = "3.0.3"
    val ScalaCheck  = "1.13.4"
    val Logback     = "1.2.1"
    val TypesafeCfg = "1.3.1"
  }

  object Libraries {
    lazy val catsEffect     = "org.typelevel"       %% "cats-effect"                  % Versions.CatsEffect

    lazy val fs2Core        = "co.fs2"              %% "fs2-core"                     % Versions.Fs2
    lazy val fs2IO          = "co.fs2"              %% "fs2-io"                       % Versions.Fs2

    lazy val http4sServer   = "org.http4s"          %% "http4s-blaze-server"          % Versions.Http4s
    lazy val http4sClient   = "org.http4s"          %% "http4s-blaze-client"          % Versions.Http4s
    lazy val http4sDsl      = "org.http4s"          %% "http4s-dsl"                   % Versions.Http4s
    lazy val http4sCirce    = "org.http4s"          %% "http4s-circe"                 % Versions.Http4s

    lazy val tsecJwtMac     = "io.github.jmcardon"  %% "tsec-jwt-mac"                 % Versions.Tsec

    lazy val circeCore      = "io.circe"            %% "circe-core"                   % Versions.Circe
    lazy val circeGeneric   = "io.circe"            %% "circe-generic"                % Versions.Circe

    lazy val flyway         = "org.flywaydb"        %  "flyway-core"                  % Versions.Flyway
    lazy val h2             = "com.h2database"      %  "h2"                           % Versions.H2
    lazy val doobieCore     = "org.tpolecat"        %% "doobie-core"                  % Versions.Doobie
    lazy val doobiePostgres = "org.tpolecat"        %% "doobie-postgres"              % Versions.Doobie
    lazy val doobieH2       = "org.tpolecat"        %% "doobie-h2"                    % Versions.Doobie
    lazy val doobieTest     = "org.tpolecat"        %% "doobie-scalatest"             % Versions.Doobie

    lazy val scalaScraper   = "net.ruippeixotog"    %% "scala-scraper"                % Versions.Scraper

    lazy val typesafeConfig = "com.typesafe"        %  "config"                       % Versions.TypesafeCfg
    lazy val logback        = "ch.qos.logback"      %  "logback-classic"              % Versions.Logback

    lazy val scalaTest      = "org.scalatest"       %% "scalatest"                    % Versions.ScalaTest   % Test
    lazy val scalaCheck     = "org.scalacheck"      %% "scalacheck"                   % Versions.ScalaCheck  % Test
  }

}
