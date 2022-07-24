package com.example.demo.config

import com.example.demo.partitioner.SamplePartitioner
import com.example.demo.worker.WorkerTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.partition.support.Partitioner
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.core.task.TaskExecutor

@Configuration
@EnableBatchProcessing
class BatchConfig {
    /** JobBuilderのFactoryクラス */
    @Autowired
    private lateinit var jobBuilderFactory: JobBuilderFactory

    /** StepBuilderのFactoryクラス */
    @Autowired
    private lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    private lateinit var samplePartitioner: Partitioner

    @Autowired
    private lateinit var workerTasklet: Tasklet

    /** 非同期実行のTaskExecutor */
    @Bean
    fun asyncTaskExecutor(): TaskExecutor {
        return SimpleAsyncTaskExecutor("worker_")
    }

    /** Stepを生成 */
    @Bean
    fun workerStep(): Step {
        return stepBuilderFactory.get("WorkerStep")
            .tasklet(workerTasklet)
            .build()
    }

    @Bean
    fun partitionStep(): Step {
        return stepBuilderFactory.get("PartitionStep")
            .partitioner("WorkerStep", samplePartitioner)   // Partitioner
            .step(workerStep()) // step
            .gridSize(3)    // 同時実行数
            .taskExecutor(asyncTaskExecutor())
            .build()
    }

    @Bean
    fun partitionJob(): Job {
        return jobBuilderFactory.get("PartitionJob")
            .start(partitionStep())
            .build()
    }
}