package controllers

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
    //Redirect(routes.Application.tradeLogs)
  }

  def tradeLogs = TODO

}