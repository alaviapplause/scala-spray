package com.utest.scalasample.dataservice

object DbDriver {

  def start = {

    /*val db = Database.forURL("jdbc:mysql://localhost:13306/spray", driver = "com.mysql.jdbc.driver")
    db.withSession { implicit session =>

      val users: TableQuery[Users] = TableQuery[Users]
      Q.updateNA("create table users(" +
        "id int not null primary key, " +
        "name varchar not null, " +
        "gender varchar not null)").execute

      Q.updateNA("create table posts(" +
        "id int not null primary key, " +
        "title varchar not null " +
        "content varchar, " +
        "user_id int not null, " +
        "foreign key(user_id) references users(id))").execute

      (Q.u + "insert into users values(\"Adi\", \"Male\")").execute

      val allUsers: List[(String, String)] = users.list
      allUsers
    }*/

    //(Q.u + "insert into users values(2, 'Ido', 'Male')").execute

  }
}