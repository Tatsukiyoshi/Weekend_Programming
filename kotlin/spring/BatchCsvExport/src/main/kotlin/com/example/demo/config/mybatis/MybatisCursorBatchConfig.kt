package com.example.demo.config.mybatis

import com.example.demo.config.BaseConfig
import com.example.demo.domain.model.Employee
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.batch.MyBatisCursorItemReader
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class MybatisCursorBatchConfig: BaseConfig() {
    /** SqlSessionFactory(MyBatisで必要) */
    @Autowired
    private lateinit var sqlSessionFactory: SqlSessionFactory

    /** MyBatisCursorItemReader */
    @Bean
    @StepScope
    fun mybatisCursorReader(): MyBatisCursorItemReader<Employee>{
        val parameterValues: MutableMap<String, Any> = mutableMapOf()
        parameterValues += "genderParam" to 1

        return MyBatisCursorItemReaderBuilder<Employee>()
            .sqlSessionFactory(sqlSessionFactory)
            .queryId("com.example.demo.repository.EmployeeMapper.findByGender")
            .parameterValues(parameterValues)
            .build()
    }

    /** MybatisCursorItemReaderを使用するStepの生成 */
    @Bean
    fun exportMybatisCursorStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("ExportMybatisCursorStep", jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(mybatisCursorReader()).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .build()
    }

    /** MybatisCursorItemReaderを使用するJobの生成 */
    @Bean("MybatisCursorJob")
    fun exportMybatisCursorJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("ExportMybatisCursorJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(exportMybatisCursorStep(jobRepository, transactionManager))
            .build()
    }
}
