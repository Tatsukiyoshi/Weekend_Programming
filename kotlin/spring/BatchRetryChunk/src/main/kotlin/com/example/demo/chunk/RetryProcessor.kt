package com.example.demo.chunk

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
@StepScope
class RetryProcessor(
    @Value("\${retry.num}")
    private var retryNum: Int
) : ItemProcessor<String, String> {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    private var count: Int = 1
    private var wkItem: String = ""

    override fun process(item: String): String? {
        if("World" == item && (retryNum > count)){
            count++
            throw Exception("Retry Test")
        }

        // 文字列の加工
        if(wkItem == ""){
            wkItem = item
        } else {
            wkItem = "$item★ "
            log.info("Processor:{}", wkItem)
        }

        return wkItem
    }

}