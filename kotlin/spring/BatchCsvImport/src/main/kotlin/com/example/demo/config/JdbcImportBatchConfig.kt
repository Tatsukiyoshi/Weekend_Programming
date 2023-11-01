package com.example.demo.config

import com.example.demo.domain.model.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
class JdbcImportBatchConfig(val transactionManager: PlatformTransactionManager) : BaseConfig() {
    /** DataSource(JDBCで必着) */
    @Autowired
    private lateinit var datasource: DataSource

    /** insert-sql(JDBC用) */
    private val insertEmployeeSql: String =
        "INSERT INTO employee(id, name, age, gender) VALUES(:id, :name, :age, :gender)"

    /** Writer(JDBC) */
    @Bean
    @StepScope
    fun jdbcWriter(): JdbcBatchItemWriter<Employee> {
        // Provider生成
        val provider: BeanPropertyItemSqlParameterSourceProvider<Employee> =
            BeanPropertyItemSqlParameterSourceProvider<Employee>()

        // 設定
        return JdbcBatchItemWriterBuilder<Employee>()   // Builderの生成
            .itemSqlParameterSourceProvider(provider)   // provider
            .sql(insertEmployeeSql)                     // SQLのセット
            .dataSource(this.datasource)                // DataSourceのセット
            .build()                                    // writerの生成
    }

    /** Stepの生成(JDBC) */
    @Bean
    fun csvImportJdbcStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("CsvImportJdbcStep", jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(this.csvReader()).listener(readListener)
            .processor(compositeProcessor()).listener(processListener)
            .writer(this.jdbcWriter()).listener(writeListener)
            .build()
    }

    /** Jobの生成(JDBC) */
    @Bean("JdbcJob")
    fun csvImportJdbcJob(jobRepository: JobRepository): Job? {
        return JobBuilder("CsvImportJdbcJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(csvImportJdbcStep(jobRepository, transactionManager))
            .build()
    }
}
