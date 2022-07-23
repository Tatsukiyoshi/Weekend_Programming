package com.example.demo.decider

import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.job.flow.FlowExecutionStatus
import org.springframework.batch.core.job.flow.JobExecutionDecider
import org.springframework.stereotype.Component

@Component
class SampleDecider: JobExecutionDecider {
    override fun decide(jobExecution: JobExecution, stepExecution: StepExecution?): FlowExecutionStatus {
        // ランダム値をStepExecutionContextから取得する
        // ステータスを変更する
        val status = when(stepExecution?.executionContext?.getInt("randomValue")){
            0 -> FlowExecutionStatus.COMPLETED.name
            else -> FlowExecutionStatus.FAILED.name
        }

        return FlowExecutionStatus(status)
    }
}
