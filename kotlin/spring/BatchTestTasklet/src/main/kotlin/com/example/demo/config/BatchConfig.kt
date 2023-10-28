package com.example.demo.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableBatchProcessing
class BatchConfig {
    @Autowired
    @Qualifier("Tasklet1")
    private lateinit var tasklet1: Tasklet

    @Autowired
    @Qualifier("Tasklet2")
    private lateinit var tasklet2: Tasklet

    @Bean
    fun testStep1(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("Step1", jobRepository)
            .tasklet(tasklet1, transactionManager)
            .build()
    }

    @Bean
    fun testStep2(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("Step2", jobRepository)
            .tasklet(tasklet2, transactionManager)
            .build()
    }

    @Bean
    fun testTaskletJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("TaskletJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(testStep1(jobRepository, transactionManager))
            .next(testStep2(jobRepository, transactionManager))
            .build()
    }
}
