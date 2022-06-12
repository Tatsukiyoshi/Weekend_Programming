package com.example.demo.csv

import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.file.FlatFileHeaderCallback
import org.springframework.stereotype.Component
import java.io.Writer

@Component
@StepScope
class CsvHeaderCallback : FlatFileHeaderCallback{
    override fun writeHeader(writer: Writer) {
        writer.write("ID, 名前, 年齢, 性別")
    }
}
