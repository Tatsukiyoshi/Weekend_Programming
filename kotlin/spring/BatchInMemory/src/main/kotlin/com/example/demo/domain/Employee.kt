package com.example.demo.domain

import lombok.Data

@Data
open class Employee{
    private var id: Int
    private var name: String
    private var age: Int
    private var gender: Int

    protected constructor() {
        this.id = 0
        this.name = ""
        this.age = 0
        this.gender = 0
    }

    constructor(id: Int, name: String, age: Int, gender: Int){
        this.id = id
        this.name = name
        this.age = age
        this.gender = gender
    }
}
