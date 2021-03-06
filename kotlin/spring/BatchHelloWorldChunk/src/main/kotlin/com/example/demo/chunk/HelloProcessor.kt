package com.example.demo.chunk

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.annotation.BeforeStep
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
@StepScope
class HelloProcessor: ItemProcessor<String, String> {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }
    private var _item: String? = null

    @Value("#{JobExecutionContext['jobKey']}")
    private var jobValue: String? = null

    @Value("#{StepExecutionContext['stepKey']}")
    private var stepValue: String? = null

    @BeforeStep
    fun beforeStep(stepExecution: StepExecution){
        log.info("jobKey={}", jobValue)
        log.info("stepKey={}", stepValue)
    }

    override fun process(item: String): String? {
        // 文字列の加工
        if(_item == null){
            _item = "item$★"
        } else {
            _item = "_item$item$★"
        }

        log.info("Processor:{}", item)

        return item
    }
}
