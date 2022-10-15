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

@Component("HelloTasklet2")
@StepScope
class HelloTasklet2: Tasklet {
    companion object {  // https://stackoverflow.com/questions/60419699
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    // 基底型はnull許容し、nullで初期化するのが妥当
    @Value("#{JobExecutionContext['jobKey']}")
    private var jobValue: String = ""

    @Value("#{StepExecutionContext['stepKey']}")
    private var stepValue: String = ""

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        log.info("Hello World2")

        // JobExecutionContextから値を取得
        log.info("jobKey={}", jobValue)

        // StepExecutionContextから値を取得
        log.info("stepKey={}", stepValue)

        return RepeatStatus.FINISHED
    }
}
