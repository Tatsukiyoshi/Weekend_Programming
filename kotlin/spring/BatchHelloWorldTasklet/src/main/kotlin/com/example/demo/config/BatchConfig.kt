package com.example.demo.config

import com.example.demo.validator.OptionalValidator
import com.example.demo.validator.RequiredValidator
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersValidator
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.CompositeJobParametersValidator
import org.springframework.batch.core.job.DefaultJobParametersValidator
import org.springframework.batch.core.job.builder.JobBuilder
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
class BatchConfig(val transactionManager: PlatformTransactionManager) {
    /** HelloTasklet */
    @Autowired
    @Qualifier("HelloTasklet")
    private lateinit var helloTasklet: Tasklet

    /** HelloTasklet2 */
    @Autowired
    @Qualifier("HelloTasklet2")
    private lateinit var helloTasklet2: Tasklet

    /** 必須入力チェックのValidator */
    @Bean
    fun defaultValidator(): JobParametersValidator {
        val validator = DefaultJobParametersValidator()

        // 必須入力
        val requireKeys: Array<String> = arrayOf("run.id", "require1")
        validator.setRequiredKeys(requireKeys)

        // オプション入力
        val optionalKeys: Array<String> = arrayOf("option1")
        validator.setOptionalKeys(optionalKeys)

        // 必須キーとオプションキーの間に重複がないことを確認
        validator.afterPropertiesSet()

        return validator
    }

    /** 複数チェックのValidator */
    @Bean
    fun compositeValidator(): JobParametersValidator{
        val validators: List<JobParametersValidator> =
            listOf(defaultValidator(),
                RequiredValidator(),
                OptionalValidator()
            )
        val compositeValidator = CompositeJobParametersValidator()
        compositeValidator.setValidators(validators)

        return compositeValidator
    }

    /** TaskletのStepを生成 */
    @Bean
    fun taskletStep1(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("HelloTaskletStep1", jobRepository)
            .tasklet(helloTasklet, transactionManager)
            .build()
    }

    /** TaskletのStepを生成 */
    @Bean
    fun taskletStep2(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("HelloTaskletStep2", jobRepository)
            .tasklet(helloTasklet2, transactionManager)
            .build()
    }

    /** TaskletのJobを生成 */
    @Bean
    fun taskletJob(jobRepository: JobRepository): Job? {
        return JobBuilder("HelloWorldTaskletJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(taskletStep1(jobRepository, transactionManager))  // 最初のStep
            .next(taskletStep2(jobRepository, transactionManager))   // 次のStep
            .validator(compositeValidator())
            .build()
    }
}
