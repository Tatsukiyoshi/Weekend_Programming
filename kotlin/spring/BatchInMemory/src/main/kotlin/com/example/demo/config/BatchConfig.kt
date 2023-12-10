package com.example.demo.config

import com.example.demo.domain.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
class BatchConfig {
    @Autowired
    private lateinit var employeeReader: ItemReader<Employee>

    /** DataSource(JDBCで必要) */
    @Autowired
    private lateinit var postgresDataSource: DataSource

    @Autowired
    @Qualifier("JpaWriter")
    private lateinit var jpaWriter: ItemWriter<Employee>

    /** insert-sql(JDBC用) */
    private final val _insertEmployeeSql: String =
        "INSERT INTO employee(id, name, age, gender)" + " VALUES(:id, :name, :age, :gender)"

    /** Writer(JDBC) */
    @Bean
    @StepScope
    fun jdbcWriter(): JdbcBatchItemWriter<Employee> {
        // Provider生成
        val provider: BeanPropertyItemSqlParameterSourceProvider<Employee> =
            BeanPropertyItemSqlParameterSourceProvider<Employee>()

        // 設定
        return JdbcBatchItemWriterBuilder<Employee>()
            .itemSqlParameterSourceProvider(provider)
            .sql(_insertEmployeeSql)
            .dataSource(postgresDataSource)
            .build()
    }

    /** Stepの生成 */
    @Bean
    fun inMemoryStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("InMemoryStep", jobRepository)
            .chunk<Employee, Employee>(1, transactionManager)
            .reader(employeeReader)
            .writer(jpaWriter)
            .build()
    }

    /** Jobの生成 */
    @Bean
    fun inMemoryJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("InMemoryJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(inMemoryStep(jobRepository, transactionManager))
            .build()
    }
}
