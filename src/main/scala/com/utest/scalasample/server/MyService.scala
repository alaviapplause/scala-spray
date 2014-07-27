package com.utest.scalasample.server

import com.utest.scalasample.dataservice.persistenceContext._
import akka.actor.Actor
import spray.http.MediaTypes._
import spray.routing._
import spray.http.MediaTypes
import com.utest.scalasample.model.User

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}

// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            println("root")
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    } ~
      path("db-create") {
        get {
          respondWithMediaType(`text/plain`) {
            complete {
              println("db creation")

              transactional {
                new User("Yossi", 32)
                new User("Mira", 100)
              }
              "created"
            }
          }
        }
      } ~
      path("users") {
        get {
          respondWithMediaType(`application/json`) {
            complete {
              val users =
                transactional {
                  all[User]
                }
              users toString
            }
          }
        }
      }
}
