package com.example.demo.integration

import com.example.demo.component.SampleComponent
import com.example.demo.config.BatchConfig
import com.example.demo.tasklet.Tasklet1
import com.example.demo.tasklet.Tasklet2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.test.context.ContextConfiguration

@SpringBatchTest
@ContextConfiguration(classes = [BatchConfig::class, Tasklet1::class, Tasklet2::class, SampleComponent::class])

@EnableAutoConfiguration
@DisplayName("IntegrationTest of Tasklet1")
class Tasklet1IntegrationTest {
    @Autowired
    private lateinit var jobLaunchTestUtils: JobLauncherTestUtils

    @Test
    @DisplayName("Status of Tasklet1 is completed")
    fun checkStatus(){
        val jobParams: JobParameters = JobParametersBuilder()
            .addString("param", "paramTest")
            .toJobParameters()

        val jobExecution: JobExecution = jobLaunchTestUtils.launchStep("Step1", jobParams)

        jobExecution.stepExecutions.forEach {
            stepExecution -> assertThat(ExitStatus.COMPLETED).isEqualTo(stepExecution.exitStatus)
        }
    }
}
