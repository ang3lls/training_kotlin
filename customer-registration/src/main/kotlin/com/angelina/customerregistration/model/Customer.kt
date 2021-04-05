package com.angelina.customerregistration.model

import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val idade: Long,
    val email: String,
    val cpf: String
)