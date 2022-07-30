package com.example.demo.config

import com.example.demo.domain.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@EnableBatchProcessing
class BatchConfig {
    @Autowired
    private lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    private lateinit var stepBuilderFactory: StepBuilderFactory

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
    fun inMemoryStep(): Step {
        return this.stepBuilderFactory.get("InMemoryStep")
            .chunk<Employee, Employee>(1)
            .reader(employeeReader)
            .writer(jpaWriter)
            .build()
    }

    /** Jobの生成 */
    @Bean
    fun inMemoryJob(): Job {
        return this.jobBuilderFactory.get("InMemoryJob")
            .incrementer(RunIdIncrementer())
            .start(inMemoryStep())
            .build()
    }
}
