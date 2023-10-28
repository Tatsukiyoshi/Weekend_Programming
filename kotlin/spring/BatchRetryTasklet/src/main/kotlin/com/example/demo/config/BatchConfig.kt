package com.example.demo.config

import com.example.demo.tasklet.RetryTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableBatchProcessing
class BatchConfig {
    @Autowired
    private lateinit var retryTasklet: Tasklet

    /** TaskletのStepを生成 */
    @Bean
    fun retryTaskletStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("RetryTaskletStep", jobRepository)
            .tasklet(retryTasklet, transactionManager)
            .build()
    }

    /** TaskletのJob生成 */
    @Bean
    fun retryTaskletJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("RetryTaskletJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(retryTaskletStep(jobRepository, transactionManager))
            .build()
    }
}
