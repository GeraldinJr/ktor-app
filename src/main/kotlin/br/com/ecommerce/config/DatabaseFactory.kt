package br.com.ecommerce.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {
    fun init() : Database {
        return Database.connect(hikari())
    }

    fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = "jdbc:postgresql:ktor-app"
        config.username= "ktor-app"
        config.password= "ktor-app"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.validate()

        return HikariDataSource(config)
    }
}