package com.example.demo.listener

import com.example.demo.domain.model.Employee
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ItemProcessListener
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class ProcessListener : ItemProcessListener<Employee, Employee> {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun beforeProcess(item: Employee) {
        // Do Nothing
    }

    override fun afterProcess(item: Employee, result: Employee?) {
        // Do Nothing
    }

    override fun onProcessError(item: Employee, e: Exception) {
        log.error("ProcessError: item={}, errorMessage={}", item, e.message, e)
    }
}