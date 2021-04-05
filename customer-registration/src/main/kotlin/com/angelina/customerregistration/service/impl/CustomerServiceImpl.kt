package com.angelina.customerregistration.service.impl

import com.angelina.customerregistration.model.Customer
import com.angelina.customerregistration.repository.CustomerRepository
import com.angelina.customerregistration.service.CustomerService
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class CustomerServiceImpl(val customerRepository: CustomerRepository): CustomerService {
    override fun create(customer: Customer) {
        this.customerRepository.save(customer)
    }

    override fun getById(id: Long): Customer? {
        return this.customerRepository.findByIdOrNull(id)
    }

    override fun findAll(): List<Customer>{
        val pageable: PageRequest = PageRequest.of(start,size)
        return this.customerRepository.findAll(pageable).toList()
    }

    override fun delete(id: Long) {
        this.customerRepository.deleteById(id)
    }

}