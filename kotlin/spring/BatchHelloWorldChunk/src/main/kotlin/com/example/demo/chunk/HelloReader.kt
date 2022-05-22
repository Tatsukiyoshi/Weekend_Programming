package com.example.demo.chunk

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.annotation.BeforeStep
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ExecutionContext
import org.springframework.batch.item.ItemReader
import org.springframework.stereotype.Component

@Component
@StepScope
class HelloReader: ItemReader<String> {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }
    private var input: Array<String?> = arrayOf("Hello", "World", "hoge", "fuga", null, "The World")
    private var index: Int = 0

    @BeforeStep
    fun beforeStep(stepExecution: StepExecution){
        // JobExecutionContextの取得
        val jobContext: ExecutionContext = stepExecution.jobExecution.executionContext

        // Mapに値登録
        jobContext.put("jobKey", "jobValue")

        // StepExecutionContextの取得
        val stepContext: ExecutionContext = stepExecution.executionContext

        // Mapに値登録
        stepContext.put("stepKey", "stepValue")
    }

    override fun read(): String? {
        // 配列の文字列を取得
        val message: String? = input[index++]

        log.info("Read:{}", message)

        return message
    }
}