package com.example.demo.config.mybatis

import com.example.demo.config.BaseConfig
import com.example.demo.domain.model.Employee
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.batch.MyBatisCursorItemReader
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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
    fun exportMybatisCursorStep(): Step {
        return this.stepBuilderFactory.get("ExportMybatisCursorStep")
            .chunk<Employee, Employee>(10)
            .reader(mybatisCursorReader()).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .build()
    }

    /** MybatisCursorItemReaderを使用するJobの生成 */
    @Bean("MybatisCursorJob")
    fun exportMybatisCursorJob(): Job {
        return this.jobBuilderFactory.get("ExportMybatisCursorJob")
            .incrementer(RunIdIncrementer())
            .start(exportMybatisCursorStep())
            .build()
    }
}
