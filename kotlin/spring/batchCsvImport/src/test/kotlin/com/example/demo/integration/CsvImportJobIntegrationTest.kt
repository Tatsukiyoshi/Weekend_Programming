package com.example.demo.integration

import com.example.demo.BatchCsvImportApplication
import com.example.demo.domain.model.Employee
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.test.context.ContextConfiguration

@SpringBatchTest
@ContextConfiguration(classes = [BatchCsvImportApplication::class])
@DisplayName("IntegrationTest of CsvImportJob")
class CsvImportJobIntegrationTest {
    @Autowired
    private lateinit var jobLauncherTestUtils: JobLauncherTestUtils

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    /** 実行結果の確認用SQL */
    private val _sql: String = "select * from employee order by id"

    private val rowMapper: RowMapper<Employee> = BeanPropertyRowMapper(Employee::class.java)

    @Test
    @DisplayName("Import User")
    fun jobTest(){
        val jobException: JobExecution = jobLauncherTestUtils.launchJob()

        jobException.stepExecutions.forEach {
            stepExecution -> assertThat(ExitStatus.COMPLETED).isEqualTo(stepExecution.exitStatus)
        }

        val resultList = jdbcTemplate.query(_sql, rowMapper)
        assertThat(resultList.size).isEqualTo(2)

        val employee1: Employee = resultList[0]
        assertThat(employee1.name).isEqualTo("テストユーザー1")

        val employee2: Employee = resultList[1]
        assertThat(employee2.name).isEqualTo("テストユーザー2")
    }
}
