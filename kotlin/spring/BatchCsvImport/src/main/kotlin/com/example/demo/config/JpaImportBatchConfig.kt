package com.example.demo.config

import com.example.demo.domain.model.Employee
import jakarta.persistence.EntityManagerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.database.JpaItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class JpaImportBatchConfig : BaseConfig() {
    /** EntityManagerFactory(JPAで必要) */
    @Autowired
    private lateinit var entityManagerFactory: EntityManagerFactory

    /** Writer(JPA) */
    @Bean
    fun jpaWriter(): JpaItemWriter<Employee> {
        val writer: JpaItemWriter<Employee> = JpaItemWriter()

        writer.setEntityManagerFactory(this.entityManagerFactory)

        return writer
    }

    /** Stepの生成(JPA) */
    @Bean
    fun csvImportJpaStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("CsvImportJpaStep", jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(csvReader()).listener(this.readListener)
            .processor(compositeProcessor()).listener(this.processListener)
            .writer(jpaWriter()).listener(this.writeListener)
            .build()
    }

    /** Jobの生成(JPA) */
    @Bean("JpaJob")
    fun csvImportJpaJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("CsvImportJpaJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(csvImportJpaStep(jobRepository, transactionManager))
            .build()
    }
}
