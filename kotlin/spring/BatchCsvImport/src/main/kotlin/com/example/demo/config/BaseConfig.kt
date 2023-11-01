package com.example.demo.config

import com.example.demo.domain.model.Employee
import org.springframework.batch.core.ItemProcessListener
import org.springframework.batch.core.ItemReadListener
import org.springframework.batch.core.ItemWriteListener
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.batch.item.support.CompositeItemProcessor
import org.springframework.batch.item.validator.BeanValidatingItemProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import java.nio.charset.StandardCharsets

abstract class BaseConfig {
    /** 性別の文字列を数値に変換するProcessor */
    @Autowired
    @Qualifier("GenderConvertProcessor")
    protected lateinit var genderConvertProcessor: ItemProcessor<Employee, Employee>

    /** データの存在をチェックするProcessor */
    @Autowired
    @Qualifier("ExistsCheckProcessor")
    protected lateinit var existsCheckProcessor: ItemProcessor<Employee, Employee>

    /** ReadListener */
    @Autowired
    protected lateinit var readListener: ItemReadListener<Employee>

    /** ProcessListener */
    @Autowired
    protected lateinit var processListener: ItemProcessListener<Employee, Employee>

    /** WriteListener */
    @Autowired
    protected lateinit var writeListener: ItemWriteListener<Employee>

    @Autowired
    private lateinit var property: SampleProperty

    /** csvファイルのReader */
    @Bean
    @StepScope
    open fun csvReader(): FlatFileItemReader<Employee> {
        // CSVのカラムに付ける名前
        val nameArray = arrayOf("id", "name", "age", "genderString")

        // ファイル読み込み設定
        return FlatFileItemReaderBuilder<Employee>()
            .name("employeeCsvReader")
            .resource(ClassPathResource(property.csvPath.toString()))
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

    /** 複数のProcessor */
    @Bean
    @StepScope
    open fun compositeProcessor(): ItemProcessor<Employee, Employee> {
        val compositeProcessor: CompositeItemProcessor<Employee, Employee> =
            CompositeItemProcessor<Employee, Employee>()

        // ProcessorList
        compositeProcessor.setDelegates(
            listOf(validationProcessor(),
                this.existsCheckProcessor, this.genderConvertProcessor))

        return compositeProcessor
    }

    /** ValidationのProcessor */
    @Bean
    @StepScope
    open fun validationProcessor(): BeanValidatingItemProcessor<Employee> {
        val validationProcessor: BeanValidatingItemProcessor<Employee> = BeanValidatingItemProcessor()

        // true: skip
        // false: throw ValidationException
        validationProcessor.setFilter(true)

        return validationProcessor
    }
}
