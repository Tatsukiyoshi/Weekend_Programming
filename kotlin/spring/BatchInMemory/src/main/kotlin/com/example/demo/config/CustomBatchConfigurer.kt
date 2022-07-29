package com.example.demo.config

import org.springframework.batch.core.configuration.annotation.BatchConfigurer
import org.springframework.batch.core.explore.JobExplorer
import org.springframework.batch.core.explore.support.MapJobExplorerFactoryBean
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.launch.support.SimpleJobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean
import org.springframework.batch.support.transaction.ResourcelessTransactionManager
import org.springframework.stereotype.Component
import org.springframework.transaction.PlatformTransactionManager
import javax.annotation.PostConstruct

@Component
class CustomBatchConfigurer: BatchConfigurer {
    private lateinit var jobRepository: JobRepository
    private lateinit var jobExplorer: JobExplorer
    private lateinit var jobLauncher: JobLauncher
    private lateinit var transactionManager: PlatformTransactionManager

    @PostConstruct
    fun init() {
        val jobRepositoryFactory = MapJobRepositoryFactoryBean()
        try {
            // JobRepositoryの設定
            this.transactionManager = ResourcelessTransactionManager()
            jobRepositoryFactory.transactionManager = transactionManager
            jobRepositoryFactory.afterPropertiesSet()
            this.jobRepository = jobRepositoryFactory.`object`

            // JobExplorerの設定
            val jobExplorerFactory = MapJobExplorerFactoryBean(jobRepositoryFactory)
            jobExplorerFactory.afterPropertiesSet()
            this.jobExplorer = jobExplorerFactory.`object`

            // JobLauncherの設定
            val jobLauncher = SimpleJobLauncher()
            jobLauncher.setJobRepository(jobRepository)
            jobLauncher.afterPropertiesSet()
            this.jobLauncher = jobLauncher
        } catch (e: Exception) {
            throw java.lang.IllegalStateException("Initialization failure", e)
        }
    }

    override fun getJobRepository(): JobRepository {
        return jobRepository
    }

    override fun getJobLauncher(): JobLauncher {
        return jobLauncher
    }

    override fun getJobExplorer(): JobExplorer {
        return jobExplorer
    }

    override fun getTransactionManager(): PlatformTransactionManager {
        return transactionManager
    }
}
