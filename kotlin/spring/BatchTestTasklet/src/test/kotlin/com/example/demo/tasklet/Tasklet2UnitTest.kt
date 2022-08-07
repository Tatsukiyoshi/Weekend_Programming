package com.example.demo.tasklet

import com.example.demo.component.SampleComponent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
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

    @Test
    @DisplayName("RepeatStatus is FINISHED")
    fun checkRepeatStatus() {
        // モック生成
        val tasklet2 = mock<Tasklet2>()

        // タスク実行
        val repeatStatus = tasklet2.execute(any(), any())

        // 結果がNullではないことを検証する
        assertThat(repeatStatus).isNotNull

        // 結果が終了（FINISHED）であることを検証する
        assertThat(repeatStatus).isEqualTo(RepeatStatus.FINISHED)
    }

    @Test
    @DisplayName("randomValue is 10")
    fun checkRandomValue() {
        // モック生成
        val tasklet2 = mock<Tasklet2>()

        // 乱数発生はかならず10を返すように設定
        mock<SampleComponent> {
            on { random() } doReturn 10
        }

        // タスク実行
        tasklet2.execute(any(), any())

        // 乱数は10だったかを検証する
        assertThat(tasklet2.getRandomValue()).isEqualTo(10)
    }
}
