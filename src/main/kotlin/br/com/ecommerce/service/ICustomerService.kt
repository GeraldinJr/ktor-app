package br.com.ecommerce.service

import br.com.ecommerce.dto.CustomerRequest

interface ICustomerService {
    suspend fun save(request: CustomerRequest) : Boolean
}