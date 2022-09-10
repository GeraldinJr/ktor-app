package br.com.ecommerce.dto

import br.com.ecommerce.models.Customer
import br.com.ecommerce.repository.Tables.CustomerTable
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow
import java.util.*

@Serializable
data class CustomerDTO(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val email: String,
)

fun dtoFromCustomer(customer: Customer) : CustomerDTO {
    return CustomerDTO (
        id = customer.id.toString(),
        firstName =  customer.firstName,
        lastName = customer.lastName,
        email = customer.email,
    )
}

@Serializable
data class CustomerRequest(
    val firstName: String?,
    val lastName: String?,
    val email: String,
)

fun customerFromRequest(request: CustomerRequest) : Customer {
    return Customer(
        id = UUID.randomUUID(),
        firstName = request.firstName,
        lastName = request.lastName,
        email = request.email,
    )
}

fun customerFromRow(row: ResultRow) : Customer {
   return Customer(
       id = row[CustomerTable.id],
       firstName = row[CustomerTable.firstName],
       lastName =  row[CustomerTable.lastName],
       email = row[CustomerTable.email],
   )
}

