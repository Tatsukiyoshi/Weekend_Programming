package com.example.demo.config

import com.example.demo.tasklet.RetryTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class BatchConfig {
    /** StepBuilderのFactoryクラス */
    @Autowired
    private lateinit var stepBuilderFactory: StepBuilderFactory

    /** JobBuilderのFactoryクラス */
    @Autowired
    private lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    private lateinit var retryTasklet: Tasklet

    /** TaskletのStepを生成 */
    @Bean
    fun retryTaskletStep(): Step {
        return stepBuilderFactory.get("RetryTaskletStep")
            .tasklet(retryTasklet)
            .build()
    }

    /** TaskletのJob生成 */
    @Bean
    fun retryTaskletJob(): Job {
        return jobBuilderFactory.get("RetryTaskletJob")
            .incrementer(RunIdIncrementer())
            .start(retryTaskletStep())
            .build()
    }
}
