package com.example.demo.domain

import lombok.Data

@Data
open class Employee(open var id: Int, open var name: String, open var age: Int, open var gender: Int)
