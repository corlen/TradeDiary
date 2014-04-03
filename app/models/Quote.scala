package models

import java.util.{Date}
import anorm._
import anorm.SqlParser._
import play.api.db.DB
import anorm.~
import play.api.Play.current
import scala.math.BigDecimal




case class Quote(code: Pk[String],
                 lastValue: BigDecimal,
                 lastUpdate: Date)

object Quote {

  val quoteParser = {
    get[Pk[String]]("quote.code") ~
    get[java.math.BigDecimal]("quote.last_value") ~
    get[Date]("quote.last_update") map {
    case code ~ lastValue ~ lastUpdate =>
        Quote(code, BigDecimal(lastValue), lastUpdate)
    }
  }

  def all(): List[Quote] = DB.withConnection { implicit c =>
    SQL("select * from quote").as(quoteParser *)

  }

}