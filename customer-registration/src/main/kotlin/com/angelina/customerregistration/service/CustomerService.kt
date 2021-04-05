package com.angelina.customerregistration.service

import com.angelina.customerregistration.model.Customer

interface CustomerService {
    fun create(customer: Customer)
    fun getById(id: Long): Customer?
    fun findAll(start: Int, size: Int): List<Customer>
    fun delete(id: Long)
}