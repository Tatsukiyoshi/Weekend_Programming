package com.example.demo.config.parallel

import com.example.demo.config.BaseConfig
import com.example.demo.domain.model.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.database.JdbcPagingItemReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.core.task.TaskExecutor

@Configuration
class ParallelBatchConfig: BaseConfig() {
    @Autowired
    private lateinit var jdbcPagingReader: JdbcPagingItemReader<Employee>

    @Bean
    fun asyncTaskExecutor(): TaskExecutor {
        return SimpleAsyncTaskExecutor("parallel_")
    }

    /** Stepを生成 */
    @Bean
    fun exportParallelStep(): Step {
        return stepBuilderFactory.get("ExportParallelStep")
            .chunk<Employee, Employee>(10)
            .reader(jdbcPagingReader).listener(readListener)
            .processor(this.genderConvertProcessor)
            .writer(csvWriter()).listener(writeListener)
            .taskExecutor(asyncTaskExecutor())      // executor
            .throttleLimit(3)                       // 同時実行数
            .build()                                // Stepの生成
    }

    /** Jobを生成 */
    @Bean
    fun exportParallelJob(): Job {
        return jobBuilderFactory.get("ExportParallelJob")
            .incrementer(RunIdIncrementer())
            .start(exportParallelStep())
            .build()
    }
}
