package com.example.demo.processor

import com.example.demo.domain.model.Employee
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

@DisplayName("UnitTest of Tasklet1")
class GenderConvertProcessorTest {
    private var processor: GenderConvertProcessor = mock()

    @Test
    @DisplayName("Male is converted to 1")
    fun convertMale(){
        val employee = Employee()

        employee.genderString = "男性"

        val result: Employee? = processor.process(employee)

        if (result != null) {
            assertThat(result.gender).isEqualTo(1)
        }
    }

    @Test
    @DisplayName("Female is converted to 2")
    fun convertFemale(){
        val employee = Employee()

        employee.genderString = "女性"

        val result: Employee? = processor.process(employee)

        if (result != null) {
            assertThat(result.gender).isEqualTo(2)
        }
    }

    @Test
    @DisplayName("Throw Exception when conversion fails")
    fun convertFail(){
        val employee = Employee()

        val result: Employee? = processor.process(employee)

        assertThat(result).isNull()
    }
}
