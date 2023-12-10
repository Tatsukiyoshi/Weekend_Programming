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
import org.springframework.batch.item.database.JdbcCursorItemReader
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
class JdbcCursorBatchConfig : BaseConfig() {
    /** DataSource(JDBCで必要) */
    @Autowired
    private lateinit var dataSource: DataSource

    /** SELECT用のSQL */
    private val _selectEmployeeSql: String = "SELECT * FROM employee where gender = ?"

    /** JdbcCursorItemReader */
    @Bean
    @StepScope
    fun jdbcCursorReader(): JdbcCursorItemReader<Employee> {
        // クエリに渡すパラメータ
        val params = arrayOf(1)

        // RowMapper
        val rowMapper: BeanPropertyRowMapper<Employee> = BeanPropertyRowMapper(Employee::class.java)

        return JdbcCursorItemReaderBuilder<Employee>()
            .dataSource(this.dataSource)
            .name("jdbcCursorItemReader")
            .sql(_selectEmployeeSql)
            .queryArguments(*params)
            .rowMapper(rowMapper)
            .build()
    }

    /** Stepの生成 */
    @Bean
    fun exportJdbcCursorStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("ExportJdbcCursorStep", jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(jdbcCursorReader()).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .build()
    }

    /** Jobの生成 */
    @Bean("JdbcCursorJob")
    fun exportJdbcCursorJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("ExportJdbcCursorJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(exportJdbcCursorStep(jobRepository, transactionManager))
            .build()
    }
}
