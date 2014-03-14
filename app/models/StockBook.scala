package models

import anorm.{NotAssigned, Pk}

case class StockBook(
                      id: Pk[Long] = NotAssigned,
                      name: String,
                      description: String,
                      color: String )

object StockBook {

  def all(): List[StockBook] = Nil

}