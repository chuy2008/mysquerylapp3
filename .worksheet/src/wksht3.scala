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
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(443); 
    val custTable = table[Customer]("customers");System.out.println("""custTable  : org.squeryl.Table[Customer] = """ + $show(custTable ))}


//    val tt = "hola"
  
//    def prr3 = println("hola")
//    columnNameFromPropertyName()
     
}



object mmm extends App
{
   wksht3.create
   wksht3.printDdl
}
