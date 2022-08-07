package com.example.demo.tasklet

import com.example.demo.component.SampleComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("Tasklet2")
@StepScope
class Tasklet2: Tasklet {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Autowired
    private lateinit var component: SampleComponent

    private var randomValue: Int = 0

    fun getRandomValue(): Int {
        return randomValue
    }

    fun setRandomValue(){
        randomValue = component.random()
    }

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        log.info("Tasklet2")

        setRandomValue()
        log.info("randomValue={}", getRandomValue())

        return RepeatStatus.FINISHED
    }
}
