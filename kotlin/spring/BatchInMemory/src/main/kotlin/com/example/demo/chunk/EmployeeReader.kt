package com.example.demo.chunk

import com.example.demo.domain.Employee
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemReader
import org.springframework.stereotype.Component

@Component
@StepScope
class EmployeeReader: ItemReader<Employee> {
    private var count: Int = 1

    private var employee: Employee = Employee(1, "user", 20, 1)

    override fun read(): Employee? {
        if(count == 1){
            count++
            return employee
        } else {
            return null
        }
    }
}
