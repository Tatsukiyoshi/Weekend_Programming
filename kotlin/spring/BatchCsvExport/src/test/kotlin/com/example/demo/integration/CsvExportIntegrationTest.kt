package com.example.demo.integration

import com.example.demo.BatchCsvExportApplication
import com.example.demo.config.SampleProperty
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.test.AssertFile
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql

@SpringBatchTest
@ContextConfiguration(classes = [BatchCsvExportApplication::class])
@DisplayName("IntegrationTest of CsvExportJob")
class CsvExportIntegrationTest {
    @Autowired
    private lateinit var jobLauncherTestUtils: JobLauncherTestUtils

    @Autowired
    private lateinit var property: SampleProperty

    /** 想定結果のファイルパス */
    private val _expectedFilePath = "src/test/resources/file/result.csv"

    @Test
    @Sql("/sql/test_data.sql")
    @DisplayName("Output File")
    fun checkStatus() {
        val jobExecution = jobLauncherTestUtils.launchJob()

        jobExecution.stepExecutions.forEach {
            stepExecution -> assertThat(ExitStatus.COMPLETED).isEqualTo(stepExecution.exitStatus)
        }

        assertThat(ExitStatus.COMPLETED).isEqualTo(jobExecution.exitStatus)

        AssertFile.assertFileEquals(
            FileSystemResource(_expectedFilePath),
            FileSystemResource(property.outputPath()))
    }
}
