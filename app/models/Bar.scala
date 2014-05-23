package models

import org.squeryl.{Schema, KeyedEntity}

case class Bar(name: Option[String]) extends KeyedEntity[Int] {
  val id: Int = 0
}

object AppDB extends Schema {
  val barTable = table[Bar]("bar")
  printDdl
  
}
