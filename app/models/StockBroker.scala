package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import scala.math.BigDecimal

case class StockBroker(
                        id: Pk[Long] = NotAssigned,
                        name: String,
                        oddLotMarketFee: BigDecimal,
                        defaultLotMarketFee: BigDecimal )

object StockBroker {

  val stockBrokerParser = {
    get[Pk[Long]]("id") ~
      get[String]("name") ~
      get[BigDecimal]("odd_lot_market_fee") ~
      get[BigDecimal]("default_lot_market_fee")  map {
      case id~name~oddLotMarketFee~defaultLotMarketFee => StockBroker(id, name, oddLotMarketFee, defaultLotMarketFee)
    }
  }

  def all(): List[StockBroker] = DB.withConnection { implicit c =>
    SQL("select * from stock_broker").as(stockBrokerParser *)
  }

}