package com.example.demo.config

import com.example.demo.tasklet.FirstTasklet
import com.example.demo.tasklet.SecondTasklet
import com.example.demo.tasklet.ThirdTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.job.builder.FlowBuilder
import org.springframework.batch.core.job.flow.Flow
import org.springframework.batch.core.job.flow.support.SimpleFlow
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.core.task.TaskExecutor

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
    @Qualifier("SecondTasklet")
    private lateinit var secondTasklet: Tasklet

    @Autowired
    @Qualifier("ThirdTasklet")
    private lateinit var thirdTasklet: Tasklet

    /** FirstStepを生成 */
    @Bean
    fun firstStep(): Step {
        return stepBuilderFactory.get("FirstStep")
            .tasklet(firstTasklet)
            .build()
    }

    /** SecondStepを生成 */
    @Bean
    fun secondStep(): Step {
        return stepBuilderFactory.get("SecondStep")
            .tasklet(secondTasklet)
            .build()
    }

    /** ThirdStepを生成 */
    @Bean
    fun thirdStep(): Step {
        return stepBuilderFactory.get("ThirdStep")
            .tasklet(thirdTasklet)
            .build()
    }

    /** FirstStepのFlowを生成 */
    @Bean
    fun firstFlow(): Flow {
        return FlowBuilder<SimpleFlow>("FirstFlow")
            .start(firstStep()) // Step1をセット
            .build()            // Flow生成
    }

    /** SecondStepのFlowを生成 */
    @Bean
    fun secondFlow(): Flow {
        return FlowBuilder<SimpleFlow>("SecondFlow")
            .start(secondStep())
            .build()
    }

    /** ThirdStepのFlowを生成 */
    @Bean
    fun thirdFlow(): Flow {
        return FlowBuilder<SimpleFlow>("ThirdFlow")
            .start(thirdStep())
            .build()
    }

    /** 非同期実行のTaskExecutor */
    @Bean
    fun asyncTaskExecutor(): TaskExecutor {
        return SimpleAsyncTaskExecutor("concurrent_")
    }

    /** Flow分割 */
    @Bean
    fun splitFlow(): Flow {
        return FlowBuilder<SimpleFlow>("splitFlow")
            .split(asyncTaskExecutor())     // Flow分割
            .add(secondFlow(), thirdFlow()) // 同時実行
            .build()
    }

    /** Jobを生成 */
    @Bean
    fun concurrentJob(): Job {
        return jobBuilderFactory.get("ConcurrentJob")
            .incrementer(RunIdIncrementer())
                .start(firstFlow()) // 最初のFlow
                .next(splitFlow())  // 分割したFlowをセット：同時実行
                .build()            // Flowを生成
                .build()            // Jobを生成
    }
}
