package controllers

import play.api.mvc._
import models.StockBook

object Application extends Controller {

  def index = Action {
    //Ok(views.html.index("Your new application is ready."))
    Redirect(routes.Application.stockBooks)
  }

  def stockBooks = Action {
    Ok(views.html.stockbooks.index(StockBook.all()))
  }

}