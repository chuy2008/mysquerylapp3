package controllers

import play.api._
import play.api.mvc._
//import com.codahale.jerkson.Json._
//import com.codahale.jerkson
import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Writes._


import org.squeryl.PrimitiveTypeMode._
import models.{AppDB, Bar}
 

object Application extends Controller {
  
  val barForm = Form(
    mapping(
      "name" -> optional(text)
    )(Bar.apply)(Bar.unapply)
  )

  def index = Action {
    Ok(views.html.index(barForm))
  }

  def addBar = Action { implicit request =>
    barForm.bindFromRequest.value map { bar =>
      inTransaction(AppDB.barTable insert bar)
      Redirect(routes.Application.index())
    } getOrElse BadRequest
  }
  
  def getBars = Action {
    val json = inTransaction 
    {
      val bars = from(AppDB.barTable)(barTable => select(barTable))
      println("Application.scala routine point 1 results = " + bars.toSeq)
      implicit object barFormat extends Format[Bar] 
      {
          def reads(json: JsValue) = JsSuccess(Bar((json \ "name").as[Option[String]]))
                                       //  (json \ "id").as[Long],
                                       //  (json \ "name").as[Option[String]]  )

          def writes(barb: Bar) = JsObject(Seq("id" -> JsNumber(barb.id),
                                                "name" -> Json.toJson(barb.name) ) )
      }
      
      
//      Json.generate(bars)
      Json.toJson(bars)
    }
    Ok(json).as(JSON)
  }  
 
//  def index = Action {
//    Ok(views.html.index("Your new application is ready."))
//  }
  
}