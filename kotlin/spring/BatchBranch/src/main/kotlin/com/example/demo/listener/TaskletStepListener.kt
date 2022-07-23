package com.example.demo.listener

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.stereotype.Component

@Component("TaskletStepListener")
class TaskletStepListener: StepExecutionListener {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun beforeStep(stepExecution: StepExecution) {
        // Do Nothing
    }

    override fun afterStep(stepExecution: StepExecution): ExitStatus? {
        log.info(stepExecution.toString())
        return stepExecution.exitStatus
    }
}
