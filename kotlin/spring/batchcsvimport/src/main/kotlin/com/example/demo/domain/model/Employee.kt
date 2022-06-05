package com.example.demo.domain.model

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Data
@Entity
open class Employee {
    @NotNull
    @Id
    var id: Int? = 0
    @NotNull
    var name: String? = null
    @Min(20)
    var age: Int? = 0
    var gender: Int? = 0
    @Transient
    var genderString: String? = null

    /** 性別の文字列を数値に変換 */
    @Throws(IllegalStateException::class)
    fun convertGenderStringToInt(){
        // 文字列を数値に変換
        gender = when (genderString) {
            "男性" -> {
                1
            }
            "女性" -> {
                2
            }
            else -> {
                val errorMsg = "Gender string is invalid:$genderString"
                throw IllegalStateException(errorMsg)
            }
        }
    }
}