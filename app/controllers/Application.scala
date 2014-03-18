package controllers

import play.api.mvc._
import models.StockBook
import models.StockBroker

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def stockBooks = Action {
    Ok(views.html.stockbooks.index(StockBook.all()))
  }

  def stockBrokers = Action {
    Ok(views.html.stockbrokers.list(StockBroker.all()))
  }

}