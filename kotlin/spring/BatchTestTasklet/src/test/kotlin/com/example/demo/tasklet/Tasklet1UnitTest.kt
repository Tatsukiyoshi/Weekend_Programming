package com.example.demo.tasklet

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.kotlin.mock
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.scope.context.StepContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.batch.test.MetaDataInstanceFactory

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("UnitTest of Tasklet1")
class Tasklet1UnitTest {
    private var tasklet1: Tasklet1 = mock()

    @Test
    @DisplayName("RepeatStatus is FINISHED")
    fun checkRepeatStatus(){
        val contribution: StepContribution = getStepContribution()
        val repeatStatus: RepeatStatus = tasklet1.execute(contribution, getChunkContext())

        assertThat(repeatStatus).isEqualTo(RepeatStatus.FINISHED)
    }

    private fun getJobExecution(): JobExecution {
        val params = JobParametersBuilder()
            .addString("param", "paramTest")
            .toJobParameters()

        val jobName = "UnitTestJob"
        val instanceId = 1L
        val executionId = 1L
        val execution: JobExecution = MetaDataInstanceFactory.createJobExecution(jobName, instanceId, executionId, params)

        execution.executionContext.putString("jobKey", "jobValue")

        return execution
    }

    private fun getStepExecution(): StepExecution {
        val execution = StepExecution("stepName", getJobExecution())
        execution.executionContext.putString("stepKey", "stepValue")

        return execution
    }

    private fun getStepContribution(): StepContribution {
        val execution: StepExecution = getStepExecution()

        return execution.createStepContribution()
    }

    private fun getChunkContext(): ChunkContext {
        val execution: StepExecution = getStepExecution()
        val stepContext = StepContext(execution)

        return ChunkContext(stepContext)
    }
}
