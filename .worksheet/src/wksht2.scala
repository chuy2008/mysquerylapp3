
import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}
import org.squeryl.{Schema, KeyedEntity}
import play.api.mvc._
import play.api._
import org.squeryl.PrimitiveTypeMode._
import play.api.libs.functional.syntax._
import play.api.http.Writeable._
import play.api.libs.json._
//import play.api.libs.functional.syntax._
import play.api.libs.json.Writes._



/*
case class Bar(name: Option[String]) extends KeyedEntity[Long] {
  val id: Long = 0
}

object AppDB extends Schema {
  val barTable = table[Bar]("bar")
}
*/


object wksht2 extends Controller
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(651); 

val echo = Action { request =>
  Ok("Got request [" + request + "]")
};System.out.println("""echo  : play.api.mvc.Action[play.api.mvc.AnyContent] = """ + $show(echo ));$skip(5); val res$0 = 
echo;System.out.println("""res0: play.api.mvc.Action[play.api.mvc.AnyContent] = """ + $show(res$0));$skip(86); val res$1 = 

//val pp = Request("hola")

Action { request => Ok("Got request [" + request + "]")};System.out.println("""res1: play.api.mvc.Action[play.api.mvc.AnyContent] = """ + $show(res$1))}


/*

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
*/



}
