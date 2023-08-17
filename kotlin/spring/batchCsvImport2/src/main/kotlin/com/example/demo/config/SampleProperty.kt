package com.example.demo.config

import lombok.Getter
import lombok.ToString
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:property/sample.properties")
@Getter
@ToString
class SampleProperty {
    @Value("\${csv.path}")
    var csvPath: String? = null
}
