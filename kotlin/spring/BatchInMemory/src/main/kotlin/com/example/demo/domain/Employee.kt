package com.example.demo.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Data

@Data
@Entity
open class Employee(
    @Id
    open var id: Int,
    open var name: String,
    open var age: Int,
    open var gender: Int
)
