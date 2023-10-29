package com.example.demo.listener

import com.example.demo.domain.model.Employee
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ItemWriteListener
import org.springframework.stereotype.Component
import java.lang.Exception


@Component
class WriteListener : ItemWriteListener<Employee> {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun beforeWrite(items: MutableList<out Employee>) {
        // Do Nothing
    }

    override fun afterWrite(items: MutableList<out Employee>) {
        log.debug("AfterWrite: count={}", items.size)
    }

    override fun onWriteError(exception: Exception, items: MutableList<out Employee>) {
        log.error("WriteError: errorMessage={}", exception.message, exception)
    }
}
