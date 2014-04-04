package models

import java.util.{Date}
import anorm._
import anorm.SqlParser._
import play.api.db.DB
import anorm.~
import play.api.Play.current
import scala.math.BigDecimal
import scala.xml.XML
import java.text.SimpleDateFormat


case class Quote(code: Pk[String],
                 lastValue: BigDecimal,
                 lastUpdate: Date)

case class QuoteFromXML(code: String, lastValue: String, lastDate: String)

object Quote {

  val quoteParser = {
    get[Pk[String]]("quote.code") ~
    get[java.math.BigDecimal]("quote.last_value") ~
    get[Date]("quote.last_update") map {
    case code ~ lastValue ~ lastUpdate =>
      Quote(code, BigDecimal(lastValue), lastUpdate)
    }
  }

  def all(): List[Quote] = DB.withConnection {
    implicit c =>
      SQL("select * from quote order by code").as(quoteParser *)

  }

  def updateQuote(code: String) {
    val xml = XML.load("http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp?CodigoPapel=" + code)

    val quotes = (xml \ "Papel").map {
      papel =>
        val code = (papel \ "@Codigo").text
        val lastValue = (papel \ "@Ultimo").text
        val lastDate = (papel \ "@Data").text
        QuoteFromXML(code, lastValue, lastDate)
    }

    for (quote <- quotes) {
      println(new SimpleDateFormat("d/MM/yyyy").parse(quote.lastDate.substring(0,10)))
      DB.withConnection { implicit c =>
        SQL("Update quote set last_value = {lastValue}, last_update = {lastUpdate} where code = {code}").on(
          'lastValue -> new java.math.BigDecimal(quote.lastValue.replace(",",".")),
          'lastUpdate -> new SimpleDateFormat("dd/MM/yyyy").parse(quote.lastDate.substring(0,10)),
          'code -> quote.code
        ).executeUpdate()
      }
    }

  }

}
