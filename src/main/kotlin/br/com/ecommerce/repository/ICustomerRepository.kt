package br.com.ecommerce.repository

import br.com.ecommerce.models.Customer
import java.util.UUID

interface ICustomerRepository {
    suspend fun save(customer: Customer) : Boolean
    suspend fun update(id: UUID,customer: Customer) : Boolean
    suspend fun deleteById(id: UUID) : Boolean
    suspend fun findByID(id: UUID) : Customer?
    suspend fun findByEmail(email: String) : Customer?
}