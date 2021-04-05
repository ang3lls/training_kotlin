package com.angelina.customerregistration.service

import com.angelina.customerregistration.model.Customer

interface CustomerService {
    fun create(customer: Customer)
    fun getById(id: Long): Customer?
    fun findAll(): List<Customer>
    fun delete(id: Long)
}