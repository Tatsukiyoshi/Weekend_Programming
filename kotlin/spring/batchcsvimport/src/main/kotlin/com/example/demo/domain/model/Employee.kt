package com.example.demo.domain.model

import lombok.Data

@Data
open class Employee {
    var id: Int? = 0
    var name: String? = null
    var age: Int? = 0
    var gender: Int? = 0
    var genderString: String? = null

    /** 性別の文字列を数値に変換 */
    @Throws(IllegalStateException::class)
    fun convertGenderStringToInt(){
        println(genderString)

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