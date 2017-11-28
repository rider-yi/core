package com.github.gvolpe.smartbackpacker

import cats.effect.Effect
import com.github.gvolpe.smartbackpacker.persistence.{AirlineDao, PostgresAirlineDao, PostgresVisaRequirementsDao, PostgresVisaRestrictionsIndexDao, VisaRequirementsDao, VisaRestrictionsIndexDao}
import com.github.gvolpe.smartbackpacker.service.{AirlineService, CountryService, ExchangeRateService, VisaRestrictionIndexService}
import doobie.util.transactor.Transactor

// It wires all the instances together
class Bindings[F[_] : Effect] {

  def xa: Transactor[F] = Transactor.fromDriverManager[F](
    "org.postgresql.Driver", "jdbc:postgresql:sb", "postgres", sys.env.getOrElse("SB_DB_PASSWORD", "")
  )

  lazy val visaRestrictionsIndexDao: VisaRestrictionsIndexDao[F] =
    new PostgresVisaRestrictionsIndexDao[F](xa)

  lazy val visaRestrictionsIndexService: VisaRestrictionIndexService[F] =
    new VisaRestrictionIndexService[F](visaRestrictionsIndexDao)

  lazy val airlineDao: AirlineDao[F] =
    new PostgresAirlineDao[F](xa)

  lazy val airlineService: AirlineService[F] =
    new AirlineService[F](airlineDao)

  lazy val visaRequirementsDao: VisaRequirementsDao[F] =
    new PostgresVisaRequirementsDao[F](xa)

  lazy val countryService: CountryService[F] =
    new CountryService[F](visaRequirementsDao, ExchangeRateService[F])

}
