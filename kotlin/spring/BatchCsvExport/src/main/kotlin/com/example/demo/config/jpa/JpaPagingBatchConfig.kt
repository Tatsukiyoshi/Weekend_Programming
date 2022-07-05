package com.example.demo.config.jpa

import com.example.demo.config.BaseConfig
import com.example.demo.domain.model.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.batch.item.database.orm.JpaNativeQueryProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManagerFactory

@Configuration
class JpaPagingBatchConfig: BaseConfig() {
    /** EntityManagerFactory(JPAで必要) */
    @Autowired
    private lateinit var entityManagerFactory: EntityManagerFactory

    /** JpaPagingItemReader */
    @Bean
    @StepScope
    fun jpaPagingReader(): JpaPagingItemReader<Employee> {
        // SQL
        val sql: String = "select * from employee where gender = :genderParam order by id"

        // クエリの設定
        val queryProvider: JpaNativeQueryProvider<Employee> = JpaNativeQueryProvider<Employee>()
        queryProvider.setSqlQuery(sql)
        queryProvider.setEntityClass(Employee::class.java)

        // クエリに渡すパラメータ
        val parameterValues: Map<String, Int> = mutableMapOf("genderParam" to 1)

        return JpaPagingItemReaderBuilder<Employee>()
            .entityManagerFactory(entityManagerFactory)
            .name("jpaPagingItemReader")
            .queryProvider(queryProvider)
            .parameterValues(parameterValues)
            .pageSize(5)
            .build()
    }

    /** JpaPagingItemReaderを使用するStepの生成 */
    fun exportJpaPagingStep(): Step {
        return this.stepBuilderFactory.get("ExportJpaPagingStep")
            .chunk<Employee, Employee>(10)
            .reader(jpaPagingReader()).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .build()
    }

    /** JpaPagingItemReaderを使用するJobの生成 */
    @Bean("JpaPagingJob")
    fun exportJpaPagingJob(): Job {
        return this.jobBuilderFactory.get("ExportJpaPagingJob")
            .incrementer(RunIdIncrementer())
            .start(exportJpaPagingStep())
            .build()
    }
}
