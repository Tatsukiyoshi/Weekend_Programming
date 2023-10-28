package com.example.demo.chunk

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter
import org.springframework.stereotype.Component

@Component
@StepScope
class HelloWriter: ItemWriter<String> {
    companion object {
        private var log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    //override fun write(items: MutableList<out String>) {
        // Kotlin: MutableList<out String> [Stringを継承したミュータブルリスト]
        // Java:   List<? extends String> [Stringの派生クラスのリスト]
        //log.info("writer:{}", items)
        //log.info("------------")
    //}

    override fun write(chunk: Chunk<out String>) {
        log.info("writer:{}", chunk.items)
        log.info("------------")
    }
}
