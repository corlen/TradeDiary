package models

import org.joda.time.DateTime

case class TradeLog(id: Long,
                    stockName: String,
                    entryDate: DateTime,
                    entryQuote: Double,
                    Quantity: Int,
                    exitDate: DateTime,
                    exitQuote: Double,
                    buyOrderFee: Double,
                    stockBookId: Long)

object TradeLog {

  def all(): List[TradeLog] = Nil

  def create(stockName: String, entryDate: DateTime, entryQuote: Double, Quantity: Int, exitDate: DateTime, exitQuote: Double, buyOrderFee: Double, groupLabel: String) {}

  def delete(id: Long) {}

}
