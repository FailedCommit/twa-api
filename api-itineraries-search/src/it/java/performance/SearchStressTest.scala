package performance;

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

import scala.collection.immutable.Nil
import scala.concurrent.duration._
import scala.language.postfixOps

class SearchStressTest extends Simulation {

  def url = "GET /api/flights/itineraries-search/itineraries"

  val protocol = karateProtocol(
    "/api/flights/itineraries-search/itineraries" -> Nil
  )

  protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")
  protocol.runner.karateEnv("perf")

  val createScenario = scenario("Search").exec(karateFeature("classpath:search/search.feature"))

  setUp(
    createScenario.inject(rampUsers(5) during (10 seconds)).protocols(protocol)
  ).assertions(
    details(url).responseTime.mean.lte(2000),
    details(url).failedRequests.count.lte(10)
  )
}

