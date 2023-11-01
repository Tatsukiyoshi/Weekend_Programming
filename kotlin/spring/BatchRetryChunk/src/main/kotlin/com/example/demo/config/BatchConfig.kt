package com.example.demo.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.retry.RetryListener
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class BatchConfig(
    @Value("\${retry.num}")
    private var retryNum: Int
) {
    @Autowired
    private lateinit var reader: ItemReader<String>

    @Autowired
    private lateinit var processor: ItemProcessor<String, String>

    @Autowired
    private lateinit var writer: ItemWriter<String>

    @Autowired
    private lateinit var retryListener: RetryListener

    /** Stepを生成 */
    @Bean
    fun retryChunkStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("RetryChunkStep", jobRepository)
            .chunk<String, String>(10, transactionManager)
            .reader(this.reader)
            .processor(this.processor)
            .writer(this.writer)
            .faultTolerant()
            .retryLimit(this.retryNum)
            .retry(Exception::class.java)
            .listener(retryListener)
            .build()
    }

    /** Jobを生成 */
    @Bean
    fun retryTaskletJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("RetryChunkJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(retryChunkStep(jobRepository, transactionManager))
            .build()
    }
}
