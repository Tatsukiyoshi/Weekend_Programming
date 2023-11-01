package com.example.demo.partitioner

import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.partition.support.Partitioner
import org.springframework.batch.item.ExecutionContext
import org.springframework.stereotype.Component

@Component
@StepScope
class SamplePartitioner: Partitioner {
    // @OptIn(ExperimentalStdlibApi::class)
    override fun partition(gridSize: Int): MutableMap<String, ExecutionContext> {
        val map = mutableMapOf<String, ExecutionContext>()

        for(i in 0..<gridSize) {
            val context = ExecutionContext()
            context.put("sampleKey", "sampleValue$i")
            map["partition$i"] =  context
        }

        return map
    }

}