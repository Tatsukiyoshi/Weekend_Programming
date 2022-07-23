package com.example.demo.tasklet

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component("FirstTasklet")
@StepScope
class FirstTasklet(
    @Value("\${batch.branch.value}")
    private var batchBranchValue: String
) : Tasklet {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        log.info("batchBranchValue:$batchBranchValue")

        contribution.exitStatus = when(batchBranchValue){
            "0" -> ExitStatus.COMPLETED
            else -> ExitStatus.FAILED
        }

        return RepeatStatus.FINISHED
    }
}
