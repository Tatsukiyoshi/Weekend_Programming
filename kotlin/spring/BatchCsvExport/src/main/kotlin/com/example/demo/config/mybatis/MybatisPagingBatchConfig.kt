package com.example.demo.config.mybatis

import com.example.demo.config.BaseConfig
import com.example.demo.domain.model.Employee
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.batch.MyBatisPagingItemReader
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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
    fun exportMybatisPagingStep(): Step {
        return this.stepBuilderFactory.get("ExportMybatisPagingStep")
            .chunk<Employee, Employee>(10)
            .reader(mybatisPagingReader()).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .build()
    }

    /** MybatisPagingItemReaderを使用するJobの生成 */
    @Bean("MybatisPagingJob")
    fun exportMybatisPagingJob(): Job {
        return this.jobBuilderFactory.get("ExportMybatisPagingJob")
            .incrementer(RunIdIncrementer())
            .start(exportMybatisPagingStep())
            .build()
    }
}
