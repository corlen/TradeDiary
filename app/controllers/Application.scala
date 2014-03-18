package controllers

import play.api.mvc._
import models.StockBroker
import models.StockBook
import models.TradeLog



object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def stockBooks = Action {
    Ok(views.html.stockbooks.list(StockBook.all()))
  }

  def stockBrokers = Action {
    Ok(views.html.stockbrokers.list(StockBroker.all()))
  }

  def tradeLogs = Action {
    Ok(views.html.tradelogs.list(TradeLog.all()))
  }

}