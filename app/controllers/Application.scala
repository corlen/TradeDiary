package controllers

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.tradeLogs)
  }

  def tradeLogs = TODO

  def newTradeLog = TODO

  def deleteTradeLog(id: Long) = TODO

}