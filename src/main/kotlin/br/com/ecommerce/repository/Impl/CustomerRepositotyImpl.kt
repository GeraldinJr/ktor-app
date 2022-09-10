package br.com.ecommerce.repository.Impl

import br.com.ecommerce.dto.customerFromRow
import br.com.ecommerce.models.Customer
import br.com.ecommerce.repository.ICustomerRepository
import br.com.ecommerce.repository.Tables.CustomerTable
import br.com.ecommerce.util.dbQuery
import org.jetbrains.exposed.sql.*
import java.util.*

class CustomerRepositotyImpl(private val database: Database) : ICustomerRepository{
    override suspend fun save(customer: Customer): Boolean {
        return dbQuery(database) {
            CustomerTable.insert {
                it[id] = customer.id
                it[firstName] = customer.firstName
                it[lastName] = customer.lastName
                it[email] = customer.email
            }.insertedCount > 0
        }
    }

    override suspend fun update(id: UUID, customer: Customer): Boolean {
        return dbQuery(database) {
            CustomerTable.update({CustomerTable.id eq id}) {
                it[firstName] = customer.firstName
                it[lastName] = customer.lastName
                it[email] = customer.email
            } > 0
        }
    }

    override suspend fun deleteById(id: UUID): Boolean {
        return dbQuery(database) {
            CustomerTable.deleteWhere { CustomerTable.id eq id } > 0
        }
    }

    override suspend fun findByID(id: UUID): Customer? {
        return dbQuery(database) {
            CustomerTable.select {CustomerTable.id eq id}
                .map { customerFromRow(it) }.firstOrNull()
        }
    }

    override suspend fun findByEmail(email: String): Customer? {
        return dbQuery(database) {
            CustomerTable.select {CustomerTable.email.lowerCase() eq email.lowercase()}
                .map { customerFromRow(it) }.firstOrNull()
        }
    }

}