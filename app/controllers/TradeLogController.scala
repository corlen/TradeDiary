package controllers

import models.TradeLog
import play.api.mvc.{Controller, Action}

object TradeLogController extends Controller{

  def tradeLogs = Action {
    Ok(views.html.tradelogs.list(TradeLog.all()))
  }

}
