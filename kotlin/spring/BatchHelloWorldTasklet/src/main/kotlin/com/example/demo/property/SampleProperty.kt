package com.example.demo.property

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
    @Value("\${sample.property}")
    var sampleProperty: String? = null
}
