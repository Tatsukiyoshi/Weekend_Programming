package com.example.demo.chunk

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemReader
import org.springframework.stereotype.Component

@Component
@StepScope
class RetryReader: ItemReader<String> {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    // 出力用文字列
    private val input: Array<String?> = arrayOf("Hello", "World", null)
    private var index: Int = 0

    override fun read(): String? {
        // 配列の文字列を取得
        var message: String? = input[index++]
        log.info("Read:{}", message)

        return message
    }
}
