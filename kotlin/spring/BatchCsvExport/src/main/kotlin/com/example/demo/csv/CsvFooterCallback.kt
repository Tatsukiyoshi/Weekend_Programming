package com.example.demo.csv

import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.file.FlatFileFooterCallback
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.Writer

@Component
@StepScope
class CsvFooterCallback : FlatFileFooterCallback{
    @Value("#{StepExecution}")
    private lateinit var stepExecution: StepExecution

    override fun writeFooter(writer: Writer) {
        val writeCount = stepExecution.writeCount
        val writeString = "合計 = $writeCount 件"
        writer.write(writeString)
    }
}
