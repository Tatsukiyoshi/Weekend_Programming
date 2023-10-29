package com.example.demo.listener

import com.example.demo.domain.model.Employee
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.SkipListener
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.stereotype.Component

@Component
@StepScope
class EmployeeSkipListener : SkipListener<Employee, Employee> {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun onSkipInRead(t: Throwable) {
        log.warn("Skip by Read Error: errorMessage={}", t.message)
    }

    override fun onSkipInProcess(item: Employee, t: Throwable) {
        log.warn("Skip by Process Error: item={}", item)
    }

    override fun onSkipInWrite(item: Employee, t: Throwable) {
        log.warn("Skip by Write Error: item={}", item)
    }
}
