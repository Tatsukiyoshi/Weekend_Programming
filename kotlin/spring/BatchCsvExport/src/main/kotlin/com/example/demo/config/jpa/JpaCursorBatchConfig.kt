package com.example.demo.config.jpa

import com.example.demo.config.BaseConfig
import com.example.demo.domain.model.Employee
import jakarta.persistence.EntityManagerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.database.JpaCursorItemReader
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder
import org.springframework.batch.item.database.orm.JpaNativeQueryProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class JpaCursorBatchConfig(val transactionManager: PlatformTransactionManager) : BaseConfig(){
    /** EntityManagerFactory(JPAで必要) */
    @Autowired
    private lateinit var entityManagerFactory: EntityManagerFactory

    /** JpaCursorItemReader */
    @Bean
    @StepScope
    fun jpaCursorReader(): JpaCursorItemReader<Employee> {
        // SQL
        val sql: String = "select * from employee where gender = :genderParam"

        // クエリの設定
        val queryProvider :JpaNativeQueryProvider<Employee> = JpaNativeQueryProvider<Employee>()
        queryProvider.setSqlQuery(sql);
        queryProvider.setEntityClass(Employee::class.java)

        // クエリに渡すパラメータ
        val parameterValues: Map<String, Int> = mutableMapOf("genderParam" to 1)

        return JpaCursorItemReaderBuilder<Employee>()
            .entityManagerFactory(entityManagerFactory)
            .name("jpaCursorItemReader")
            .queryProvider(queryProvider)
            .parameterValues(parameterValues)
            .build()
    }

    /** JpaCursorItemReaderを使用するStepの生成 */
    @Bean
    fun exportJpaCursorStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("ExportJpaCursorStep",jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(jpaCursorReader()).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .build()
    }

    /** JpaCursorItemReaderを使用するJobの生成 */
    @Bean("JpaCursorJob")
    fun exportJpaCursorJob(jobRepository: JobRepository): Job {
        return JobBuilder("ExportJpaCursorJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(exportJpaCursorStep(jobRepository, transactionManager))
            .build()
    }
}
