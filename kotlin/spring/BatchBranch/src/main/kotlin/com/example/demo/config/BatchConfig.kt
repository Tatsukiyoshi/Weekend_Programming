package com.example.demo.config

import com.example.demo.listener.TaskletStepListener
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.job.flow.FlowExecutionStatus
import org.springframework.batch.core.job.flow.JobExecutionDecider
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
class BatchConfig {
    @Autowired
    @Qualifier("FirstTasklet")
    private lateinit var firstTasklet: Tasklet

    @Autowired
    @Qualifier("SuccessTasklet")
    private lateinit var successTasklet: Tasklet

    @Autowired
    @Qualifier("FailTasklet")
    private lateinit var failTasklet: Tasklet

    @Autowired
    @Qualifier("TaskletStepListener")
    private lateinit var taskletStepListener: TaskletStepListener

    @Autowired
    @Qualifier("RandomTasklet")
    private lateinit var randomTasklet: Tasklet

    @Autowired
    private lateinit var sampleDecider: JobExecutionDecider

    /** FirstStepを生成 */
    @Bean
    fun firstStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("FirstStep", jobRepository)
            .tasklet(firstTasklet, transactionManager)
            .listener(taskletStepListener)
            .build()
    }

    /** SuccessStepを生成 */
    @Bean
    fun successStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("SuccessStep", jobRepository)
            .tasklet(successTasklet, transactionManager)
            .build()
    }

    /** FailStepを生成 */
    @Bean
    fun failStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("FailStep", jobRepository)
            .tasklet(failTasklet, transactionManager)
            .build()
    }

    /** RandomStepを生成 */
    @Bean
    fun randomStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("RandomStep", jobRepository)   // Builderの取得
            .tasklet(randomTasklet, transactionManager)         // Taskletのセット
            .listener(taskletStepListener)                      // listener
            .build()                                            // Stepの生成
    }

    /** Taskletの分岐Jobを生成 */
    @Bean
    fun taskletBranchJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("TaskletBranchJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(firstStep(jobRepository, transactionManager))
            .on(ExitStatus.COMPLETED.exitCode)
            .to(successStep(jobRepository, transactionManager))
            .from(firstStep(jobRepository, transactionManager))
            .on(ExitStatus.FAILED.exitCode)
            .to(failStep(jobRepository, transactionManager))
            .end()
            .build()
    }

    /** RandomTaskletの分岐Jobを生成 */
    @Bean
    fun randomTaskletBranchJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("RandomTaskletBranchJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(randomStep(jobRepository, transactionManager))    // 最初のStep
            .next(sampleDecider)    // Deciderへ
            .from(sampleDecider)    // Deciderへ戻る
            .on(FlowExecutionStatus.COMPLETED.name)
            .to(successStep(jobRepository, transactionManager))
            .from(sampleDecider)    // Deciderへ戻る
            .on(FlowExecutionStatus.FAILED.name)
            .to(failStep(jobRepository, transactionManager))
            .end()                  // 分岐終了
            .build()                // Jobの生成
    }
}
