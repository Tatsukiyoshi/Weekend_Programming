package com.example.demo.config

import com.example.demo.domain.model.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.database.JpaItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManagerFactory

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
    fun csvImportJpaStep(): Step {
        return this.stepBuilderFactory?.get("CsvImportJpaStep")
            ?.chunk<Employee, Employee>(10)
            ?.reader(csvReader())?.listener(this.readListener!!)
            ?.processor(compositeProcessor())?.listener(this.processListener!!)
            ?.writer(jpaWriter())?.listener(this.writeListener!!)
            ?.build()!!
    }

    /** Jobの生成(JPA) */
    @Bean("JpaJob")
    fun csvImportJpaJob(): Job {
        return this.jobBuilderFactory?.get("CsvImportJpaJob")
            ?.incrementer(RunIdIncrementer())
            ?.start(csvImportJpaStep())
            ?.build()!!
    }
}
