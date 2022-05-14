package com.example.demo.config

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
    /** JobBuilderのFactoryクラス */
    @Autowired
    private lateinit var jobBuilderFactory: JobBuilderFactory

    /** StepBuilderのFactoryクラス */
    @Autowired
    private lateinit var stepBuilderFactory: StepBuilderFactory

    /** HelloTasklet */
    @Autowired
    private lateinit var helloTasklet: Tasklet

    /** TaskletのStepを生成 */
    @Bean
    fun taskletStep1(): Step {
        return stepBuilderFactory.get("HelloTaskletStep1")
            .tasklet(helloTasklet)
            .build()
    }

    /** TaskletのJobを生成 */
    @Bean
    fun taskletJob(): Job? {
        return jobBuilderFactory.get("HelloWorldTaskletJob")
            .incrementer(RunIdIncrementer())
            .start(taskletStep1())
            .build()
    }
}