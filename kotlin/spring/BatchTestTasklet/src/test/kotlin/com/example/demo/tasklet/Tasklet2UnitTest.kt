package com.example.demo.tasklet

import com.example.demo.component.SampleComponent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.repeat.RepeatStatus

@ExtendWith(MockitoExtension::class)
@DisplayName("UnitTest of Tasklet2")
class Tasklet2UnitTest {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)

        @BeforeAll
        fun initAll(){
            log.info("=== Tasklet2 UnitTest Start ===")
        }

        @AfterAll
        fun tearDownAll(){
            log.info("=== Tasklet2 UnitTest End ===")
        }
    }

    @InjectMocks
    private var tasklet2 = mock<Tasklet2>()

    @Mock
    private var component = mock<SampleComponent>()

    @Test
    @DisplayName("RepeatStatus is FINISHED")
    fun checkRepeatStatus() {
        // テスト
        val repeatStatus: RepeatStatus = tasklet2.execute(any(), any())

        // 検証
        assertThat(repeatStatus).isNotNull
        assertThat(repeatStatus).isEqualTo(RepeatStatus.FINISHED)
    }

    @Test
    @DisplayName("randomValue is 10")
    fun checkRandomValue() {
        // 準備
        whenever(component.random()).thenReturn(10)

        // テスト
        tasklet2.execute(any(), any())

        // 検証
        assertThat(tasklet2.getRandomValue()).isEqualTo(10)
    }
}
