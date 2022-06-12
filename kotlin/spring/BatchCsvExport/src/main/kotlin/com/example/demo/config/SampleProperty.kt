package com.example.demo.config

import lombok.Getter
import lombok.ToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import java.io.File

@Component
@PropertySource("classpath:property/sample.properties")
@Getter
@ToString
class SampleProperty {
    companion object {  //
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
    @Value("\${file.name}")
    private var fileName: String? = null

    @Value("\${file.output.directory}")
    private var fileOutputDirectory: String? = null

    fun outputPath(): String {
        val outputPath: String = fileOutputDirectory + File.separator + fileName

        log.debug("outputPath = {}", outputPath)

        return outputPath
    }
}
