package com.example.demo.config.mybatis

import com.example.demo.config.BaseConfig
import com.example.demo.domain.model.Employee
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.batch.MyBatisPagingItemReader
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder
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
class MybatisPagingBatchConfig: BaseConfig() {
    /** SqlSessionFactory(MyBatisで必要) */
    @Autowired
    private lateinit var sqlSessionFactory: SqlSessionFactory

    /** MyBatisPagingItemReader */
    @Bean
    @StepScope
    fun mybatisPagingReader(): MyBatisPagingItemReader<Employee> {
        // クエリーに渡すパラメータ
        val parameterValues: MutableMap<String, Any> = mutableMapOf<String, Any>()
        parameterValues += "genderParam" to 1

        return MyBatisPagingItemReaderBuilder<Employee>()
            .sqlSessionFactory(sqlSessionFactory)
            .queryId("com.example.demo.repository.EmployeeMapper.findByGenderPaging")
            .parameterValues(parameterValues)
            .pageSize(10)
            .build()
    }

    /** MybatisPagingItemReaderを使用するStepの生成 */
    @Bean
    fun exportMybatisPagingStep(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Step {
        return StepBuilder("ExportMybatisPagingStep", jobRepository)
            .chunk<Employee, Employee>(10, transactionManager)
            .reader(mybatisPagingReader()).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .build()
    }

    /** MybatisPagingItemReaderを使用するJobの生成 */
    @Bean("MybatisPagingJob")
    fun exportMybatisPagingJob(jobRepository: JobRepository, transactionManager: PlatformTransactionManager): Job {
        return JobBuilder("ExportMybatisPagingJob", jobRepository)
            .incrementer(RunIdIncrementer())
            .start(exportMybatisPagingStep(jobRepository, transactionManager))
            .build()
    }
}
