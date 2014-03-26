package controllers

import play.api.mvc._
import models.StockBroker
import models.StockBook
import models.TradeLog
import models.Quote
import models.Report
import play.api.data.Forms._
import play.api.data._
import anorm.NotAssigned
import anorm.Pk


object Application extends Controller {

  def index = Action {
    Ok(views.html.index.render(Report.totalInvested(),Report.totalGrossProfit()))
  }

  def stockBooks = Action {
    Ok(views.html.stockbooks.list(StockBook.all(), stockBookForm))
  }

  def stockBrokers = Action {
    Ok(views.html.stockbrokers.list(StockBroker.all()))
  }

  def tradeLogs = Action {
    Ok(views.html.tradelogs.list(TradeLog.all()))
  }

  def quotes = Action {
    Ok(views.html.quotes.list(Quote.all()))
  }

  def newStockBook = Action { implicit request =>
      stockBookForm.bindFromRequest.fold(
      errors => BadRequest(views.html.stockbooks.list(StockBook.all(), errors)),
      stockBook => {
        StockBook.create(stockBook)
        Redirect(routes.Application.stockBooks)
      }
    )
  }

  val stockBookForm = Form(
    mapping(
      "id" -> ignored(NotAssigned: Pk[Long]),
      "Book Name" -> nonEmptyText,
      "Description" -> text,
      "Color" -> text
    )(StockBook.apply)(StockBook.unapply)
  )

}