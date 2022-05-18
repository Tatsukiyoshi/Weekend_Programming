package com.example.demo.listener

import org.springframework.batch.core.StepExecutionListener
import org.springframework.stereotype.Component

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution

@Component
class HelloStepListener: StepExecutionListener {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun beforeStep(stepExecution: StepExecution) {
        log.info("Before Step: {}", stepExecution)
    }

    override fun afterStep(stepExecution: StepExecution): ExitStatus? {
        log.info("After Step: {}", stepExecution)

        return stepExecution.exitStatus
    }
}