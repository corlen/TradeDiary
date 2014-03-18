package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class StockBroker(
                        id: Pk[Long] = NotAssigned,
                        name: String,
                        oddLotMarketFee: java.math.BigDecimal,
                        defaultLotMarketFee: java.math.BigDecimal )

object StockBroker {

  val stockBrokerParser = {
    get[Pk[Long]]("id") ~
      get[String]("name") ~
      get[java.math.BigDecimal]("odd_lot_market_fee") ~
      get[java.math.BigDecimal]("default_lot_market_fee")  map {
      case id~name~oddLotMarketFee~defaultLotMarketFee => StockBroker(id, name, oddLotMarketFee, defaultLotMarketFee)
    }
  }

  def all(): List[StockBroker] = DB.withConnection { implicit c =>
    SQL("select * from stock_broker").as(stockBrokerParser *)
  }

}