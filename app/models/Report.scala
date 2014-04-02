package models


import anorm._
import anorm.SqlParser._
import play.api.db.DB
import play.api.Play.current
import java.math.BigDecimal
import java.util.Date

case class SummaryReportByStock(code: String,
                                totalQuotes: BigDecimal,
                                investedValue: BigDecimal,
                                presentGrossValue: BigDecimal,
                                higherQuoteBought: BigDecimal,
                                lowerQuoteBought: BigDecimal,
                                oldestTradeDate: Date)

object Report {

  def totalInvested(): BigDecimal = DB.withConnection { implicit connection =>
                      SQL("select sum(entry_quote*quantity) from trade_log")
                      .as(scalar[java.math.BigDecimal].single)
  }

  def totalGrossProfit(): BigDecimal = DB.withConnection { implicit connection =>
    SQL("select sum(a.quantity*b.last_value)-sum(a.entry_quote*a.quantity) from trade_log a inner join quote b on a.quote_code=b.code")
    .as(scalar[java.math.BigDecimal].single)

  }

  val summaryReportByStockParser = {
    get[String]("quote.code") ~
    get[BigDecimal]("total_quotes") ~
    get[BigDecimal]("invested_value") ~
    get[BigDecimal]("present_gross_value") ~
    get[BigDecimal]("higher_quote_bought") ~
    get[BigDecimal]("lower_quote_bought") ~
    get[Date]("oldest_trade") map {
      case code ~ totalQuotes ~ investedValue ~ presentGrossValue ~ higherQuoteBought ~ lowerQuoteBought ~ oldestTradeDate =>
        SummaryReportByStock(code, totalQuotes, investedValue, presentGrossValue, higherQuoteBought, lowerQuoteBought, oldestTradeDate)
    }
  }

  def summaryReportByStock(): List[SummaryReportByStock] = DB.withConnection { implicit connection =>
    SQL(
      """
        select
        quote.code,
        sum(trade_log.quantity) as total_quotes,
        sum(trade_log.quantity*trade_log.entry_quote) as invested_value,
        sum(quote.last_value*trade_log.quantity) as present_gross_value,
        max(trade_log.entry_quote) as higher_quote_bought,
        min(trade_log.entry_quote) as lower_quote_bought,
        min(trade_log.entry_date) as oldest_trade
        from quote inner join trade_log on quote.code=trade_log.quote_code
        group by quote.code
        order by quote.code
      """).as(summaryReportByStockParser *)
  }

}