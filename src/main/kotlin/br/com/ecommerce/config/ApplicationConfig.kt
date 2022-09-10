package br.com.ecommerce.config

import br.com.ecommerce.repository.Impl.CustomerRepositotyImpl
import br.com.ecommerce.routes.customerRoutes
import br.com.ecommerce.service.Impl.CustomerServiceImpl
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.setup() {
    val db = DatabaseFactory.init()
    val repo = CustomerRepositotyImpl(db)
    val service = CustomerServiceImpl(repo)

    routing {
        get("/teste") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
        customerRoutes(service)
    }
}