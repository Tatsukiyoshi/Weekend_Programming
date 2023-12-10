package com.example.demo.config.jdbc

import com.example.demo.config.BaseConfig
import com.example.demo.domain.model.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.database.JdbcPagingItemReader
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.RowMapper
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
class JdbcPagingBatchConfig : BaseConfig() {
    /** DataSource(JDBCで必要) */
    @Autowired
    private lateinit var dataSource: DataSource

    /** Pagingのクエリー設定(JDBC用) */
    @Bean
    public fun queryProvider(): SqlPagingQueryProviderFactoryBean {
        // SQL
        var provider = SqlPagingQueryProviderFactoryBean()

        provider.setDataSource(dataSource)
        provider.setSelectClause("SELECT id, name, age, gender")
        provider.setFromClause("FROM employee")
        provider.setWhereClause("WHERE gender = :genderParam")
        provider.setSortKey("id")

        return provider
    }

    /** JdbcPagingItemReader */
    @Bean
    @StepScope
    public fun jdbcPagingReader(): JdbcPagingItemReader<Employee> {
        // クエリーに渡すパラメータ
        val parameterValues: MutableMap<String, Any> = mutableMapOf()
        parameterValues += "genderParam" to 1

        // RowMapper
        var rowMapper: RowMapper<Employee> = BeanPropertyRowMapper(Employee::class.java)

        return JdbcPagingItemReaderBuilder<Employee>()
            .name("jdbcPagingItemReader")
            .dataSource(dataSource)
            .queryProvider(queryProvider().`object`)
            .parameterValues(parameterValues)
            .rowMapper(rowMapper)
            .pageSize(5)
            .build()
    }

    /** JdbcPagingItemReaderを使用するStepの生成 */
    @Bean
    fun exportJdbcPagingStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("ExportJdbcPagingStep", jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(jdbcPagingReader()).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .build()
    }

    /** JdbcPagingItemReaderを使用するJobの生成 */
    @Bean("JdbcPagingJob")
    public fun exportJdbcPagingJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("ExportJdbcPagingJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(exportJdbcPagingStep(jobRepository, transactionManager))
            .build()
    }
}
