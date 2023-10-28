package com.example.demo.listener

import com.example.demo.domain.model.Employee
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ItemWriteListener
import org.springframework.batch.item.Chunk
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class WriteListener : ItemWriteListener<Employee> {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun beforeWrite(chunk: Chunk<out Employee>) {
        // Do Nothing
    }

    override fun afterWrite(chunk: Chunk<out Employee>) {
        log.debug("AfterWrite: count={}", chunk.items.size)
    }

    override fun onWriteError(exception: Exception, chunk: Chunk<out Employee>) {
        log.error("WriteError: errorMessage={}", exception.message, exception)
    }
}
