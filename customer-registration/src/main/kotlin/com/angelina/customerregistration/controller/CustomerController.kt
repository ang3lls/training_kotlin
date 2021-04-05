package com.angelina.customerregistration.controller

import com.angelina.customerregistration.model.Customer
import com.angelina.customerregistration.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @PostMapping()
    fun create(@RequestBody customer: Customer): ResponseEntity<Customer>{
        this.customerService.create(customer)
        return ResponseEntity(customer, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        var customer =  this.customerService.getById(id)
        
        return if (customer != null)
            return ResponseEntity(customer, HttpStatus.OK)
        else
            return ResponseEntity(ErrorManager("Customer não encontrado", "Customer ${id} não localizado"), HttpStatus.NOT_FOUND)
    }

    @GetMapping()
    fun findAll(@RequestParam(required = false, defaultValue = "0")start: Int,
                @RequestParam(required = false, defaultValue = "3")size: Int) : ResponseEntity<List<Customer>>{

        var listCustomer = this.customerService.findAll(start,size)
        var status = if(listCustomer.size == 0) HttpStatus.NOT_FOUND else HttpStatus.OK

        return ResponseEntity(listCustomer, status)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit>{
        var status = HttpStatus.NOT_FOUND
        if (this.customerService.getById(id) != null){
            status = HttpStatus.ACCEPTED
            this.customerService.delete(id)
        }
        return ResponseEntity(Unit, status)
    }

    private fun ErrorManager(s: String, s1: String) {

    }

}