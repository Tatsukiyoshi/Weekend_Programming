package com.example.demo.config

import com.example.demo.listener.TaskletStepListener
import org.springframework.batch.core.ExitStatus
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
    /** StepBuilderのFactoryクラス */
    @Autowired
    private lateinit var stepBuilderFactory: StepBuilderFactory

    /** JobBuilderのFactoryクラス */
    @Autowired
    private lateinit var jobBuilderFactory: JobBuilderFactory

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

    /** FirstStepを生成 */
    @Bean
    fun firstStep(): Step {
        return stepBuilderFactory.get("FirstStep")
            .tasklet(firstTasklet)
            .listener(taskletStepListener)
            .build()
    }

    /** SuccessStepを生成 */
    @Bean
    fun successStep(): Step {
        return stepBuilderFactory.get("SuccessStep")
            .tasklet(successTasklet)
            .build()
    }

    /** FailStepを生成 */
    @Bean
    fun failStep(): Step {
        return stepBuilderFactory.get("FailStep")
            .tasklet(failTasklet)
            .build()
    }

    /** Taskletの分岐Jobを生成 */
    @Bean
    fun taskletBranchJob(): Job {
        return jobBuilderFactory.get("TaskletBranchJob")
            .incrementer(RunIdIncrementer())
            .start(firstStep())
            .on(ExitStatus.COMPLETED.exitCode)
            .to(successStep())
            .from(firstStep())
            .on(ExitStatus.FAILED.exitCode)
            .to(failStep())
            .end()
            .build()
    }
}
