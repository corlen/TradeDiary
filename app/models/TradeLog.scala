package models

import java.util.{Date}
import anorm._
import anorm.SqlParser._
import play.api.db.DB
import anorm.~
import play.api.Play.current
import scala.math.BigDecimal
import scala.math.BigInt



case class TradeLog(id: Pk[Long] = NotAssigned,
                    quoteCode: String,
                    entryDate: Date,
                    entryQuote: BigDecimal,
                    quantity: BigInt,
                    exitDate: Option[Date],
                    exitQuote: Option[java.math.BigDecimal],      //TODO: isso aqui vai dar problema na hora de criar o form
                    stockBookId: Long,
                    stockBrokerId: Long,
                    stockBookName: String,
                    stockBrokerName: String,
                    lotType: String)

object TradeLog {

  val tradeLogParser = {
      get[Pk[Long]]("trade_log.id") ~
      get[String]("trade_log.quote_code") ~
      get[Date]("trade_log.entry_date") ~
      get[java.math.BigDecimal]("trade_log.entry_quote") ~
      get[java.math.BigInteger]("trade_log.quantity") ~
      get[Option[Date]]("trade_log.exit_date") ~
      get[Option[java.math.BigDecimal]]("trade_log.exit_quote") ~
      get[Long]("trade_log.stock_book_id") ~
      get[Long]("trade_log.stock_broker_id") ~
      get[String]("stock_book.name") ~
      get[String]("stock_broker.name") ~
      get[String]("lot_type") map {
      case id ~ quoteCode ~ entryDate ~ entryQuote ~ quantity ~ exitDate ~ exitQuote ~ stockBookId ~ stockBrokerId ~ stockBookName ~ stockBrokerName ~ lotType =>
        TradeLog(id, quoteCode, entryDate, BigDecimal(entryQuote), BigInt(quantity), exitDate, exitQuote, stockBookId, stockBrokerId, stockBookName, stockBrokerName, lotType)
      }
  }

  def all(): List[TradeLog] = DB.withConnection { implicit connection =>
    SQL("""
          select * from trade_log tl
            inner join stock_book sb on tl.stock_book_id=sb.id
            inner join stock_broker sbr on sbr.id=tl.stock_broker_id
        """).as(tradeLogParser *)
  }

  def findById(id: Long): Option[TradeLog] = DB.withConnection { implicit connection =>
    SQL("""
          select * from trade_log tl
            inner join stock_book sb on tl.stock_book_id=sb.id
            inner join stock_broker sbr on sbr.id=tl.stock_broker_id
            where tl.id = {id}
        """).on('id -> id).as(TradeLog.tradeLogParser.singleOpt)
  }

}
