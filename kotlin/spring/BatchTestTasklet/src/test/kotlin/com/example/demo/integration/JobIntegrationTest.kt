package com.example.demo.integration

import com.example.demo.BatchTestTaskletApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

@SpringBatchTest
@ContextConfiguration(classes = [BatchTestTaskletApplication::class])
@DisplayName("IntegrationTest of Job")
class JobIntegrationTest {
    @Autowired
    private lateinit var jobLauncherTestUtils: JobLauncherTestUtils

    @Test
    @DisplayName("Status of Step and Job is Completed")
    fun executeJob(){
        val jobParams = JobParametersBuilder()
            .addString("param", "JobTest")
            .toJobParameters()

        val jobExecution = jobLauncherTestUtils.launchJob(jobParams)

        jobExecution.stepExecutions.forEach {
            stepExecution -> assertThat(ExitStatus.COMPLETED).isEqualTo(stepExecution.exitStatus)
        }

        assertThat(ExitStatus.COMPLETED).isEqualTo(jobExecution.exitStatus)
    }

    @Test
    @DisplayName("Status of Step1 is Completed")
    fun executeStep1(){
        val jobParams = JobParametersBuilder()
            .addString("param", "StepTest")
            .toJobParameters()

        val jobExecution = jobLauncherTestUtils.launchStep("Step1", jobParams)

        jobExecution.stepExecutions.forEach {
            stepExecution -> assertThat(ExitStatus.COMPLETED).isEqualTo(stepExecution.exitStatus)
        }
    }
}
