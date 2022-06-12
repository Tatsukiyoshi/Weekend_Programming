package com.example.demo.listener

import com.example.demo.domain.model.Employee
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ItemReadListener
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class ReadListener : ItemReadListener<Employee> {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun beforeRead() {
        // Do Nothing
    }

    override fun onReadError(ex: Exception) {
        log.error("ReadError: errorMessage: {}", ex.message, ex)
    }

    override fun afterRead(item: Employee) {
        log.debug("AfterRead: {}", item)
    }
}
