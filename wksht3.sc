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
    val custTable = table[Customer]("customers")  //> custTable  : org.squeryl.Table[Customer] = org.squeryl.Table@b4af2c1


//    val tt = "hola"
  
//    def prr3 = println("hola")
//    columnNameFromPropertyName()
     
}



object mmm extends App
{
   wksht3.create
   wksht3.printDdl
}