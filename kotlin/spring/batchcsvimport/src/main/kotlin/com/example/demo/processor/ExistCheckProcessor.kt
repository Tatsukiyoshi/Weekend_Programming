package com.example.demo.processor

import com.example.demo.domain.model.Employee
import com.example.demo.repository.EmployeeJdbcRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("ExistsCheckProcessor")
@StepScope
class ExistCheckProcessor: ItemProcessor<Employee, Employee>{
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Autowired
    private var employeeRepository: EmployeeJdbcRepository? = null

    /** 従業員が存在するかチェックする */
    override fun process(item: Employee): Employee? {
        val exists: Boolean = employeeRepository?.exists(item.id!!) == true

        if(exists){
            log.info("Skip because it already exists: {}", item)
            return null
        }

        return item
    }
}
