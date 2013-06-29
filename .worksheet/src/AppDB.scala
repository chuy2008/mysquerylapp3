import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}
import org.squeryl.{Schema, KeyedEntity}

case class Bar(name: Option[String]) extends KeyedEntity[Long] {
  val id: Long = 0
}

object AppDB extends Schema {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(272); 
  val barTable = table[Bar]("bar");System.out.println("""barTable  : org.squeryl.Table[Bar] = """ + $show(barTable ))}
}

object wksht2
{


  val barForm = Form(
    mapping(
      "name" -> optional(text)
    )(Bar.apply)(Bar.unapply)
  )

  barForm




}
