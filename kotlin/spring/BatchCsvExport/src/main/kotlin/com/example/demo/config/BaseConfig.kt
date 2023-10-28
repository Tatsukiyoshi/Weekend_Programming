package com.example.demo.config

import com.example.demo.domain.model.Employee
import org.springframework.batch.core.ItemReadListener
import org.springframework.batch.core.ItemWriteListener
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.file.FlatFileFooterCallback
import org.springframework.batch.item.file.FlatFileHeaderCallback
import org.springframework.batch.item.file.FlatFileItemWriter
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor
import org.springframework.batch.item.file.transform.DelimitedLineAggregator
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import java.nio.charset.StandardCharsets

@EnableBatchProcessing
open class BaseConfig {
    /** 性別の数値を文字列に変換するProcessor */
    @Autowired
    lateinit var genderConvertProcessor: ItemProcessor<Employee, Employee>

    @Autowired
    private var property: SampleProperty? = null

    @Autowired
    lateinit var readListener: ItemReadListener<Employee>

    @Autowired
    lateinit var writeListener: ItemWriteListener<Employee>

    @Autowired
    private lateinit var csvHeaderCallback: FlatFileHeaderCallback

    @Autowired
    private lateinit var csvFooterCallback: FlatFileFooterCallback

    /** CSV出力のWriterを生成 */
    @Bean
    @StepScope
    open fun csvWriter(): FlatFileItemWriter<Employee>{
        // ファイル出力先設定
        val filePath: String? = property?.outputPath()
        val outputResource: FileSystemResource? = filePath?.let { FileSystemResource(it) }

        // 区切り文字設定
        val aggregator: DelimitedLineAggregator<Employee> = DelimitedLineAggregator<Employee>()
        aggregator.setDelimiter(DelimitedLineTokenizer.DELIMITER_COMMA)

        // 出力フィールドの設定
        val extractor: BeanWrapperFieldExtractor<Employee> = BeanWrapperFieldExtractor<Employee>()
        extractor.setNames(arrayOf("id", "name", "age", "genderString"))
        aggregator.setFieldExtractor(extractor)

        return FlatFileItemWriterBuilder<Employee>()
            .name("employeeCsvWriter")
            .resource(outputResource!!)
            .append(false)
            .lineAggregator(aggregator)
            .headerCallback(csvHeaderCallback)
            .footerCallback(csvFooterCallback)
            .encoding(StandardCharsets.UTF_8.name())
            .build()
    }
}
