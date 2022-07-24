package com.example.demo.tasklet

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component("ThirdTasklet")
@StepScope
class ThirdTasklet: Tasklet {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        log.info("ThirdTasklet")
        return RepeatStatus.FINISHED
    }
}
