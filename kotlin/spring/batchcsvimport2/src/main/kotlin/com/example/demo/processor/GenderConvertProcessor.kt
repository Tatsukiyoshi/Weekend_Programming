package com.example.demo.processor

import com.example.demo.domain.model.Employee
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component("GenderConvertProcessor")
@StepScope
class GenderConvertProcessor : ItemProcessor<Employee, Employee> {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun process(item: Employee): Employee? {
        try {
            item.convertGenderStringToInt()
        } catch(e: Exception){
            log.warn(e.message, e)

            // スキップ
            return null
        }

        return item
    }
}
