package com.example.demo.listener

import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.stereotype.Component

import org.slf4j.LoggerFactory
import org.slf4j.Logger

@Component
class HelloJobListener: JobExecutionListener {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun beforeJob(jobExecution: JobExecution){
        log.info("Before Job: {}", jobExecution)
    }

    override fun afterJob(jobExecution: JobExecution) {
        log.info("After Job: {}", jobExecution)
    }
}
