package com.example.demo.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecutionListener
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepExecutionListener
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableBatchProcessing
class BatchConfig(val transactionManager: PlatformTransactionManager) {
    /** HelloReader */
    @Autowired
    private lateinit var reader: ItemReader<String>

    /** HelloProcessor */
    @Autowired
    private lateinit var processor: ItemProcessor<String, String>

    /** HelloWriter */
    @Autowired
    private lateinit var writer: ItemWriter<String>

    @Autowired
    private lateinit var jobListener: JobExecutionListener

    @Autowired
    private lateinit var stepListener: StepExecutionListener

    /** ChunkのStepを生成 */
    @Bean
    fun chunkStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("HelloWorldChunkStep", jobRepository)
            .chunk<String, String>(1, transactionManager)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .listener(stepListener)
            .build()
    }

    /** Jobを生成 */
    @Bean
    fun chunkJob(jobRepository: JobRepository): Job {
        return JobBuilder("HelloWorldChunkJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(chunkStep(jobRepository, transactionManager))
            .listener(jobListener)
            .build()
    }
}
