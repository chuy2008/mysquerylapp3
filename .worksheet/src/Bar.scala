import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}
import org.squeryl.{Schema, KeyedEntity}
import play.api.mvc._
import play.api._
import org.squeryl.PrimitiveTypeMode._
import play.api.libs.functional.syntax._

case class Bar(name: Option[String]) extends KeyedEntity[Long] {
  val id: Long = 0
}

object AppDB extends Schema {
  val barTable = table[Bar]("bar")
}

object wksht2
{


  val barForm = Form(
    mapping(
      "name" -> optional(text)
    )(Bar.apply)(Bar.unapply)
  )

  //barForm
  
    def addBar = Action { implicit request =>
    barForm.bindFromRequest.value map { bar =>
      inTransaction(AppDB.barTable insert bar)
      Redirect(routes.Application.index())
    } getOrElse BadRequest
  }




}
