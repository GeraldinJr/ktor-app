package br.com.ecommerce.models

import java.util.*

data class Customer(
    val id: UUID,
    val firstName: String?,
    val lastName: String?,
    val email: String,
)