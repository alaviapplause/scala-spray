package com.utest.scalasample.dataservice

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.storage.relational.PooledJdbcRelationalStorage
import net.fwbrasil.activate.storage.relational.idiom.mySqlDialect

object persistenceContext extends ActivateContext {

  val storage = new PooledJdbcRelationalStorage {
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val user = Option("root")
    val password = Option("")
    val url = "jdbc:mysql://localhost:13306/spray"
    val dialect = mySqlDialect
  }

  override protected def entitiesPackages = List("com.utest.scalasample.model")
}