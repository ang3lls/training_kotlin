package com.angelina.customerregistration.repository

import com.angelina.customerregistration.model.Customer
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: PagingAndSortingRepository<Customer, Long> {
}