package controllers

import play.api.mvc._
import models.StockBroker
import models.StockBook


object Application extends Controller {

  def index = Action {
    Ok(views.html.index.render())
  }

  def stockBooks = Action {
    Ok(views.html.stockbooks.list(StockBook.all()))
  }

  def stockBrokers = Action {
    Ok(views.html.stockbrokers.list(StockBroker.all()))
  }

}