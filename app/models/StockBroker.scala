package models

import anorm.{NotAssigned, Pk}

case class StockBroker(
                        id: Pk[Long] = NotAssigned,
                        name: String,
                        oddLotMarketFee: Double,
                        defaultLotMarketFee: Double )

object StockBroker {

  def all(): List[StockBroker] = Nil

}