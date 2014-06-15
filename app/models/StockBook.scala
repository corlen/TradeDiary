package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
//http://stackoverflow.com/questions/24192229/how-to-handle-anorms-pk-deprecation
case class StockBook(
                      id: Pk[Long] = NotAssigned,
                      name: String,
                      description: String,
                      color: String )

object StockBook {

  val stockBookParser = {
    get[Pk[Long]]("id") ~
    get[String]("name") ~
    get[String]("description") ~
    get[String]("color")  map {
        case id~name~description~color => StockBook(id, name, description, color)
      }
  }

  def all(): List[StockBook] = DB.withConnection { implicit c =>
    SQL("select * from stock_book").as(stockBookParser *)
  }

}