
//import play.api._
//import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}
import play.api.libs.json._
//import play.api.libs.functional.syntax._
//import play.api.libs.json.Writes._


object wksht1
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(567); val res$0 = 

    Map(
       "url"-> "http://nytimes.com",
       "attributes" -> Map("name" -> "nytimes",
                           "country" -> "US",
                           "id" -> 25
                           ),
       "links" -> List("http://link1",
                       "http://link2"
                       )
     );System.out.println("""res0: scala.collection.immutable.Map[String,Object] = """ + $show(res$0));$skip(39); 

  val json: JsValue = Json.parse("5");System.out.println("""json  : play.api.libs.json.JsValue = """ + $show(json ));$skip(37); 
  
  val jsonNumber = Json.toJson(4);System.out.println("""jsonNumber  : play.api.libs.json.JsValue = """ + $show(jsonNumber ));$skip(50); 
  
  val jsonArray = Json.toJson(Seq(1, 2, 3, 4));System.out.println("""jsonArray  : play.api.libs.json.JsValue = """ + $show(jsonArray ));$skip(105); 

  val jsonArray2 = Json.toJson(Seq(Json.toJson(1), Json.toJson("Bob"), Json.toJson(3), Json.toJson(4)))

case class User(
  id: Long,
  firstName: String,
  lastName: String,
  email: Option[String]
) {
  def this() = this(0, "","", Some(""))
}

implicit object UserFormat extends Format[User] {
  def reads(json: JsValue) = JsSuccess(User(
    (json \ "id").as[Long],
    (json \ "firstName").as[String],
    (json \ "lastName").as[String],
    (json \ "email").as[Option[String]]
  ))

  def writes(user: User) = JsObject(Seq(
    "id" -> JsNumber(user.id),
    "firstName" -> JsString(user.firstName),
    "lastName" -> JsString(user.lastName),
    "email" -> Json.toJson(user.email)
  ))
};System.out.println("""jsonArray2  : play.api.libs.json.JsValue = """ + $show(jsonArray2 ));$skip(647); val res$1 = 
  
  User(1L, "Some", "Person", Some("s.p@example.com"));System.out.println("""res1: wksht1.User = """ + $show(res$1))}
  
  

}
