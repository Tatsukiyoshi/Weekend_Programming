package com.example.demo.domain

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Id

@Data
@Entity
open class Employee(
    @Id
    open var id: Int,
    open var name: String,
    open var age: Int,
    open var gender: Int
)
