package com.example.demo.chunk

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter
import org.springframework.stereotype.Component

@Component
@StepScope
class RetryWriter: ItemWriter<String> {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun write(chunk: Chunk<out String>) {
        // コンソールに出力
        chunk.items.forEach {
            item -> log.info("Writer: $item")
        }
    }
}
