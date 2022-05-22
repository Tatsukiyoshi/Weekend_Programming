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

@Component("HelloTasklet")
@StepScope
class HelloTasklet: Tasklet {
    companion object {  // https://stackoverflow.com/questions/60419699
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Value("#{jobParameters['require1']}")
    private val require1: String? = null

    @Value("#{jobParameters['option1']}")
    private val option1: Int = 0

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        log.info("Hello World")

        // JobExecutionContextの取得
        val jobContext: ExecutionContext = contribution.stepExecution.jobExecution.executionContext

        // Mapに値登録
        jobContext.put("jobKey", "jobValue")

        // StepExecutionContextの取得
        val stepContext: ExecutionContext = contribution.stepExecution.executionContext

        // Mapに値登録
        stepContext.put("stepKey", "stepValue")

        // JobParameterの確認
        log.info("require1={}", require1)
        log.info("option1={}", option1)

        return RepeatStatus.FINISHED
    }
}
