package com.example.demo.chunk

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
@StepScope
class HelloProcessor: ItemProcessor<String, String> {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    private var _item: String? = null

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
