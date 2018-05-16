package controllers

import javax.inject._
import org.pac4j.core.client.IndirectClient
import org.pac4j.core.context.Pac4jConstants
import org.pac4j.core.credentials.Credentials
import org.pac4j.core.profile.CommonProfile
import org.pac4j.play.PlayWebContext
import org.pac4j.play.scala.{Security, SecurityComponents}
import play.api._
import play.api.mvc._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
class HomeController @Inject()(val controllerComponents: SecurityComponents, configuration: Configuration) extends Security[CommonProfile] {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(configuration.get[String]("baseUrl"))
  }

  def indirectIndex(): Action[AnyContent] = Secure("IndirectBasicAuthClient") { implicit request =>
    Ok(views.html.index())
  }

  def forceLogin = Action { request =>
    val context: PlayWebContext = new PlayWebContext(request, playSessionStore)
    val client = config.getClients.findClient(context.getRequestParameter(Pac4jConstants.DEFAULT_CLIENT_NAME_PARAMETER)).asInstanceOf[IndirectClient[Credentials, CommonProfile]]
    Redirect(client.getRedirectAction(context).getLocation)
  }
}
