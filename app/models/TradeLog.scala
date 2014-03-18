package models

import java.util.{Date}
import anorm._
import anorm.SqlParser._
import play.api.db.DB
import anorm.~
import play.api.Play.current


case class TradeLog(id: Pk[Long] = NotAssigned,
                    stockName: String,
                    entryDate: Date,
                    entryQuote: java.math.BigDecimal,
                    quantity: java.math.BigInteger,
                    exitDate: Option[Date],
                    exitQuote: Option[java.math.BigDecimal],
                    stockBookId: Long,
                    stockBrokerId: Long )

object TradeLog {

  val tradeLogParser = {
      get[Pk[Long]]("trade_log.id") ~
      get[String]("trade_log.stock_name") ~
      get[Date]("trade_log.entry_date") ~
      get[java.math.BigDecimal]("trade_log.entry_quote") ~
      get[java.math.BigInteger]("trade_log.quantity") ~
      get[Option[Date]]("trade_log.exit_date") ~
      get[Option[java.math.BigDecimal]]("trade_log.exit_quote") ~
      get[Long]("trade_log.stock_book_id") ~
      get[Long]("trade_log.stock_broker_id")  map {
      case id ~ stockName ~ entryDate ~ entryQuote ~ quantity ~ exitDate ~ exitQuote ~ stockBookId ~ stockBrokerId =>
        TradeLog(id, stockName, entryDate, entryQuote, quantity, exitDate, exitQuote, stockBookId, stockBrokerId)
    }
  }

  def all(): List[TradeLog] = DB.withConnection { implicit c =>
    SQL("select * from trade_log").as(tradeLogParser *)
  }

}
