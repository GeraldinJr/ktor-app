package br.com.ecommerce.service.Impl

import br.com.ecommerce.dto.CustomerRequest
import br.com.ecommerce.dto.customerFromRequest
import br.com.ecommerce.repository.ICustomerRepository
import br.com.ecommerce.service.ICustomerService
import kotlin.jvm.Throws

class CustomerServiceImpl(
    private val repo: ICustomerRepository,
    ) : ICustomerService {

    override suspend fun save(request: CustomerRequest): Boolean {
        if (repo.findByEmail(request.email) != null) return false
        return repo.save(
            customerFromRequest(request)
        )
    }

}