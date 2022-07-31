package com.example.demo.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class BatchConfig {
    @Autowired
    private lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    private lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    @Qualifier("Tasklet1")
    private lateinit var tasklet1: Tasklet

    @Autowired
    @Qualifier("Tasklet2")
    private lateinit var tasklet2: Tasklet

    @Bean
    fun testStep1(): Step {
        return stepBuilderFactory.get("Step1")
            .tasklet(tasklet1)
            .build()
    }

    @Bean
    fun testStep2(): Step {
        return stepBuilderFactory.get("Step2")
            .tasklet(tasklet2)
            .build()
    }

    @Bean
    fun testTaskletJob(): Job {
        return jobBuilderFactory.get("TaskletJob")
            .incrementer(RunIdIncrementer())
            .start(testStep1())
            .next(testStep2())
            .build()
    }
}
