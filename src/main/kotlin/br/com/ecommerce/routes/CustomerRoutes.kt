package br.com.ecommerce.routes

import br.com.ecommerce.dto.CustomerRequest
import br.com.ecommerce.service.ICustomerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.routing.post

const val API_VERSION = "/v1"
const val CUSTOMERS = "$API_VERSION/customer"

fun Route.customerRoutes(
    service: ICustomerService,
    ) {

    route(CUSTOMERS) {
        post("/register") {
            val customerRequest = try {
                call.receive<CustomerRequest>()
            } catch (e : Exception) {
                println(e.message)
                call.respond(HttpStatusCode.BadRequest, "Requisição inválida")
                return@post
            }

            try {
                service.save(customerRequest)
                call.respond(HttpStatusCode.Created)
            } catch (e : Exception) {
                println(e.message)
                call.respond(HttpStatusCode.Conflict, "Erro ao salvar")
            }
        }
    }
}