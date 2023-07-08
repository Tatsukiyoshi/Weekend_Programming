package com.example.demo.config

import org.springframework.batch.core.Job
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class TestConfig {
    @Autowired
    @Qualifier("JdbcJob")
    private lateinit var jdbcJob: Job

    @Bean
    @Primary
    fun testJob(): Job {
        return jdbcJob
    }
}
