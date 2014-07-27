package com.utest.scalasample.model

import net.fwbrasil.activate.entity.Entity
import net.fwbrasil.activate.migration.Migration
import com.utest.scalasample.dataservice.persistenceContext._

case class User(val name: String, val age: Int) extends Entity {
  def invariantNameMustNotBeEmpty = invariant {
    name != null && name.nonEmpty
  }
}

class CreateUserTableMigration extends Migration {

  def timestamp = 201407241232l
  def up = {
    table[User]
      .createTable(
        _.column[String]("name"),
        _.column[Int]("age"))
  }
}