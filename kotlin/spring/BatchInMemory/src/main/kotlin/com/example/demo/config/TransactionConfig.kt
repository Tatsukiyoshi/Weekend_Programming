package com.example.demo.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager

/** TransactionManager設定クラス */
@Configuration
class TransactionConfig {
    @Autowired
    private lateinit var entityManagerFactory: EntityManagerFactory

    @Bean
    @Primary
    fun jpaTransactionManager(): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}
