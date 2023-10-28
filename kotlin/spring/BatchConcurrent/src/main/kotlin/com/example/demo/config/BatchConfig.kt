package com.example.demo.config

import com.example.demo.tasklet.FirstTasklet
import com.example.demo.tasklet.SecondTasklet
import com.example.demo.tasklet.ThirdTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.job.builder.FlowBuilder
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.job.flow.Flow
import org.springframework.batch.core.job.flow.support.SimpleFlow
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.core.task.TaskExecutor
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableBatchProcessing
class BatchConfig {
    @Autowired
    @Qualifier("FirstTasklet")
    private lateinit var firstTasklet: Tasklet

    @Autowired
    @Qualifier("SecondTasklet")
    private lateinit var secondTasklet: Tasklet

    @Autowired
    @Qualifier("ThirdTasklet")
    private lateinit var thirdTasklet: Tasklet

    /** FirstStepを生成 */
    @Bean
    fun firstStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("FirstStep", jobRepository)
            .tasklet(firstTasklet, transactionManager)
            .build()
    }

    /** SecondStepを生成 */
    @Bean
    fun secondStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("SecondStep", jobRepository)
            .tasklet(secondTasklet, transactionManager)
            .build()
    }

    /** ThirdStepを生成 */
    @Bean
    fun thirdStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("ThirdStep", jobRepository)
            .tasklet(thirdTasklet, transactionManager)
            .build()
    }

    /** FirstStepのFlowを生成 */
    @Bean
    fun firstFlow(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Flow {
        return FlowBuilder<SimpleFlow>("FirstFlow")
            .start(firstStep(jobRepository, transactionManager)) // Step1をセット
            .build()            // Flow生成
    }

    /** SecondStepのFlowを生成 */
    @Bean
    fun secondFlow(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Flow {
        return FlowBuilder<SimpleFlow>("SecondFlow")
            .start(secondStep(jobRepository, transactionManager))
            .build()
    }

    /** ThirdStepのFlowを生成 */
    @Bean
    fun thirdFlow(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Flow {
        return FlowBuilder<SimpleFlow>("ThirdFlow")
            .start(thirdStep(jobRepository, transactionManager))
            .build()
    }

    /** 非同期実行のTaskExecutor */
    @Bean
    fun asyncTaskExecutor(): TaskExecutor {
        return SimpleAsyncTaskExecutor("concurrent_")
    }

    /** Flow分割 */
    @Bean
    fun splitFlow(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Flow {
        return FlowBuilder<SimpleFlow>("splitFlow")
            .split(asyncTaskExecutor())     // Flow分割
            .add(secondFlow(jobRepository, transactionManager),
                thirdFlow(jobRepository, transactionManager)) // 同時実行
            .build()
    }

    /** Jobを生成 */
    @Bean
    fun concurrentJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("ConcurrentJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(firstFlow(jobRepository, transactionManager)) // 最初のFlow
            .next(splitFlow(jobRepository, transactionManager))  // 分割したFlowをセット：同時実行
            .build()            // Flowを生成
            .build()            // Jobを生成
    }
}
