package com.example.demo.tasklet

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.item.ExecutionContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component("RandomTasklet")
class RandomTasklet: Tasklet {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        // 0 or 1の値をランダムに生成する
        val random: Random = Random
        val randomValue: Int = random.nextInt(2)

        log.info("randomValue={}", randomValue)

        // StepExecutionContextに生成した値を登録
        val stepExecutionContext: ExecutionContext = contribution.stepExecution.executionContext
        stepExecutionContext.put("randomValue", randomValue)

        return RepeatStatus.FINISHED
    }
}
