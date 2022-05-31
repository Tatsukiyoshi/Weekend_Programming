package com.example.demo.config

import com.example.demo.domain.model.Employee
import org.springframework.batch.core.ItemProcessListener
import org.springframework.batch.core.ItemReadListener
import org.springframework.batch.core.ItemWriteListener
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import java.nio.charset.StandardCharsets

@EnableBatchProcessing
abstract class BaseConfig {
    @Autowired
    protected var jobBuilderFactory: JobBuilderFactory? = null

    @Autowired
    protected var stepBuilderFactory: StepBuilderFactory? = null

    /** 性別の文字列を数値に変換するProcessor */
    @Autowired
    @Qualifier("GenderConvertProcessor")
    protected var genderConvertProcessor: ItemProcessor<Employee, Employee>? = null

    /** ReadListener */
    @Autowired
    protected var readListener: ItemReadListener<Employee>? = null

    /** ProcessListener */
    @Autowired
    protected var processListener: ItemProcessListener<Employee, Employee>? = null

    /** WriteListener */
    @Autowired
    protected var writeListener: ItemWriteListener<Employee>? = null

    @Autowired
    private var property: SampleProperty? = null

    /** csvファイルのReader */
    @Bean
    @StepScope
    open fun csvReader(): FlatFileItemReader<Employee> {
        // CSVのカラムに付ける名前
        val nameArray = arrayOf("id", "name", "age", "genderString")

        // ファイル読み込み設定
        return FlatFileItemReaderBuilder<Employee>()
            .name("employeeCsvReader")
            .resource(ClassPathResource(property?.csvPath.toString()))
            .linesToSkip(1)
            .encoding(StandardCharsets.UTF_8.name())
            .delimited()
            .names(*nameArray)
            .fieldSetMapper(object : BeanWrapperFieldSetMapper<Employee>() {
                init {
                    setTargetType(Employee::class.java)
                }
            })
            .build()
    }
}
