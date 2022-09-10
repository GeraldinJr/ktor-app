package br.com.ecommerce

import br.com.ecommerce.config.setup
import io.ktor.server.application.*
import br.com.ecommerce.plugins.*
import io.ktor.server.locations.*


fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module(testing: Boolean = false) {
    configureSerialization()
    configureRouting()
    setup()
}
