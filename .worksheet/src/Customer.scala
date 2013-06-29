import org.squeryl.{Schema, KeyedEntity}
import org.squeryl.adapters.{H2Adapter, PostgreSqlAdapter}
import org.squeryl.internals.DatabaseAdapter
import org.squeryl.{Session, SessionFactory}
import play.api.db.DB
import play.api.GlobalSettings
import play.api.Application

case class Customer(val name: String) extends KeyedEntity[Long]
{
    val id: Long = 0
}


object wksht3 extends Schema
{
    val custTable = table[Customer]("customers")


//    val tt = "hola"
  
//    def prr3 = println("hola")
//    columnNameFromPropertyName()
     
}



object mmm extends App
{
  def onStart(app: Application) {
    SessionFactory.concreteFactory = app.configuration.getString("db.default.driver") match {
      case Some("org.h2.Driver") => Some(() => getSession(new H2Adapter, app))
      case Some("org.postgresql.Driver") => Some(() => getSession(new PostgreSqlAdapter, app))
      case _ => sys.error("Database driver must be either org.h2.Driver or org.postgresql.Driver")
    }
  }

  def getSession(adapter:DatabaseAdapter, app: Application) = Session.create(DB.getConnection()(app), adapter)


   wksht3.create
   wksht3.printDdl
}
