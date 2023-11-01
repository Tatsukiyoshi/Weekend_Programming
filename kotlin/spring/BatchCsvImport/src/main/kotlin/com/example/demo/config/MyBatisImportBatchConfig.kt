package com.example.demo.config

import com.example.demo.domain.model.Employee
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.batch.MyBatisBatchItemWriter
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class MyBatisImportBatchConfig : BaseConfig() {
    /** SqlSessionFactory(MyBatisで必要) */
    @Autowired
    private var sqlSessionFactory: SqlSessionFactory? = null

    /** Writer(MyBatis) */
    @Bean
    fun mybatisWriter(): MyBatisBatchItemWriter<Employee> {
        return MyBatisBatchItemWriterBuilder<Employee>()
            .sqlSessionFactory(sqlSessionFactory)
            .statementId("com.example.demo.repository.EmployeeMapper.insertOne")
            .build()
    }

    /** Stepの生成(MyBatis) */
    @Bean
    fun csvImportMybatisStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("CsvImportMybatisStep", jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(csvReader()).listener(this.readListener)
            .processor(compositeProcessor()).listener(this.processListener)
            .writer(mybatisWriter()).listener(this.writeListener)
            .build()
    }

    /** Jobの生成(MyBatis) */
    @Bean("MybatisJob")
    fun csvImportMybatisJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job? {
        return JobBuilder("CsvImportMybatisJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(csvImportMybatisStep(jobRepository, transactionManager))
            .build()
    }
}
