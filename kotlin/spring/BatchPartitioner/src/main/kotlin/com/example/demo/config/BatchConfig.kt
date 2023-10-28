package com.example.demo.config

import com.example.demo.partitioner.SamplePartitioner
import com.example.demo.worker.WorkerTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.partition.support.Partitioner
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.core.task.TaskExecutor
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableBatchProcessing
class BatchConfig {
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
    fun workerStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("WorkerStep", jobRepository)
            .tasklet(workerTasklet, transactionManager)
            .build()
    }

    @Bean
    fun partitionStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("PartitionStep", jobRepository)
            .partitioner("WorkerStep", samplePartitioner)   // Partitioner
            .step(workerStep(jobRepository, transactionManager)) // step
            .gridSize(3)    // 同時実行数
            .taskExecutor(asyncTaskExecutor())
            .build()
    }

    @Bean
    fun partitionJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("PartitionJob", jobRepository)
            .start(partitionStep(jobRepository, transactionManager))
            .build()
    }
}