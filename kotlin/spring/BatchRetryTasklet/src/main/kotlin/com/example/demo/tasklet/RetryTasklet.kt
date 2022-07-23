package com.example.demo.tasklet

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component("RetryTasklet")
@StepScope
class RetryTasklet(
    @Value("\${retry.num}")
    private var retryNum: Int
) : Tasklet {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    private var count: Int = 0

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        while(retryNum > count){
            log.info("count={}", count + 1)
            count++

            // リトライする
            return RepeatStatus.CONTINUABLE
        }

        return RepeatStatus.FINISHED
    }
}
