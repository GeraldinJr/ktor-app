package br.com.ecommerce.repository.Tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object CustomerTable : Table("customer"){
    val id: Column<UUID> = uuid("id").uniqueIndex()
    val firstName: Column<String?> = text("first_name").nullable()
    val lastName: Column<String?> = text("last_name").nullable()
    val email: Column<String> = text("email").uniqueIndex()
}