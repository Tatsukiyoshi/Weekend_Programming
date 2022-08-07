package com.example.demo.tasklet

import com.example.demo.component.SampleComponent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.springframework.batch.repeat.RepeatStatus

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("UnitTest of Tasklet2")
class Tasklet2UnitTest {
    @Test
    @DisplayName("RepeatStatus is FINISHED")
    fun checkRepeatStatus() {
        // モック生成
        val tasklet2: Tasklet2 = mock()

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
        val tasklet2: Tasklet2 = mock()

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
