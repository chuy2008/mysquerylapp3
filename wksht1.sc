
//import play.api._
//import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}
import play.api.libs.json._
//import play.api.libs.functional.syntax._
//import play.api.libs.json.Writes._


object wksht1
{

    Map(
       "url"-> "http://nytimes.com",
       "attributes" -> Map("name" -> "nytimes",
                           "country" -> "US",
                           "id" -> 25
                           ),
       "links" -> List("http://link1",
                       "http://link2"
                       )
     )                                            //> res0: scala.collection.immutable.Map[String,Object] = Map(url -> http://nyti
                                                  //| mes.com, attributes -> Map(name -> nytimes, country -> US, id -> 25), links 
                                                  //| -> List(http://link1, http://link2))

  val json: JsValue = Json.parse("5")             //> json  : play.api.libs.json.JsValue = 5
  
  val jsonNumber = Json.toJson(4)                 //> jsonNumber  : play.api.libs.json.JsValue = 4
  
  val jsonArray = Json.toJson(Seq(1, 2, 3, 4))    //> jsonArray  : play.api.libs.json.JsValue = [1,2,3,4]

  val jsonArray2 = Json.toJson(Seq(Json.toJson(1), Json.toJson("Bob"), Json.toJson(3), Json.toJson(4)))
                                                  //> jsonArray2  : play.api.libs.json.JsValue = [1,"Bob",3,4]

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
}
  
  User(1L, "Some", "Person", Some("s.p@example.com"))
                                                  //> res1: wksht1.User = User(1,Some,Person,Some(s.p@example.com))
  
  

}