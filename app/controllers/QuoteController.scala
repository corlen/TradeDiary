package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import models.Quote

object QuoteController extends Controller{

  def quotes = Action {
    Ok(views.html.quotes.list(Quote.all()))
  }

}
