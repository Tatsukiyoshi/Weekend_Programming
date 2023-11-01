package com.example.demo.config

import com.example.demo.domain.model.Employee
import org.mybatis.spring.batch.MyBatisBatchItemWriter
import org.springframework.batch.core.Job
import org.springframework.batch.core.SkipListener
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class SkipImportBatchConfig(val transactionManager: PlatformTransactionManager) : BaseConfig() {
    /** Listener */
    @Autowired
    private lateinit var employeeSkipListener: SkipListener<Employee, Employee>

    @Autowired
    private lateinit var mybatisWriter: MyBatisBatchItemWriter<Employee>

    /** Stepの生成(Skip) */
    @Bean
    fun csvImportSkipStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("CsvImportSkipStep", jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(csvReader()).listener(this.readListener)
            .processor(genderConvertProcessor).listener(this.processListener)
            .writer(mybatisWriter)
            .faultTolerant()                        // FaultTolerant
            .skipLimit(Int.MAX_VALUE)               // 最大件数
            .skip(RuntimeException::class.java)
            .listener(this.employeeSkipListener)    // listener
            .build()
    }

    /** Jobの生成(Skip) */
    @Bean("SkipJob")
    fun csvImportSkipJob(jobRepository: JobRepository): Job {
        return JobBuilder("CsvImportSkipJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(csvImportSkipStep(jobRepository, transactionManager))
            .build()
    }
}
