package models

import java.util.{Date}
import anorm.{NotAssigned, Pk}

case class TradeLog(id: Pk[Long] = NotAssigned,
                    stockName: String,
                    entryDate: Date,
                    entryQuote: Double,
                    quantity: Int,
                    exitDate: Option[Date],
                    exitQuote: Option[Double],
                    stockBookId: Long,
                    stockBrokerId: Long )

object TradeLog {

  def all(): List[TradeLog] = Nil

}
