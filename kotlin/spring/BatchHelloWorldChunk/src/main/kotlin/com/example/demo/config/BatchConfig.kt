package com.example.demo.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecutionListener
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepExecutionListener
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
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
    fun chunkStep(): Step {
        return stepBuilderFactory.get("HelloWorldChunkStep")
            .chunk<String, String>(1)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .listener(stepListener)
            .build()
    }

    /** Jobを生成 */
    @Bean
    fun chunkJob(): Job {
        return jobBuilderFactory.get("HelloWorldChunkJob")
            .incrementer(RunIdIncrementer())
            .start(chunkStep())
            .listener(jobListener)
            .build()
    }
}
