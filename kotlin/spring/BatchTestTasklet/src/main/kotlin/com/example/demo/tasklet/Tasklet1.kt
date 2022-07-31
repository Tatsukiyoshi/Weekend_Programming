package com.example.demo.tasklet

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.item.ExecutionContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component("Tasklet1")
@StepScope
class Tasklet1: Tasklet {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Value("#{jobParameters['param']}")
    private lateinit var param: String

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        log.info("Tasklet1")
        log.info("param={}", param)

        // JobExecutionContextの取得
        val jobContext: ExecutionContext = contribution.stepExecution.jobExecution.executionContext
        log.info("jobKey={}", jobContext.get("jobKey"))

        // StepExecutionContextの取得
        val stepContext: ExecutionContext = contribution.stepExecution.executionContext
        log.info("stepKey={}", stepContext.get("stepKey"))

        return RepeatStatus.FINISHED
    }
}
