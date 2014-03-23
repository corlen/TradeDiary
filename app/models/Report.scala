package models


import anorm._
import anorm.SqlParser._
import play.api.db.DB
import play.api.Play.current

object Report {

  def totalInvested(): java.math.BigDecimal = DB.withConnection { implicit c =>
                      SQL("select sum(entry_quote*quantity) from trade_log")
                      .as(scalar[java.math.BigDecimal].single)
  }

  def totalGrossProfit(): java.math.BigDecimal = DB.withConnection { implicit c =>
    SQL("select sum(a.quantity*b.last_value)-sum(a.entry_quote*a.quantity) from trade_log a inner join quote b on a.quote_code=b.code")
    .as(scalar[java.math.BigDecimal].single)

  }

}