package com.example.demo.domain.model

import lombok.Data

@Data
open class Employee {
    private var id: Int? = 0
    private lateinit var name: String
    private var age: Int? = 0
    private var gender: Int? = 0
    private lateinit var genderString: String

    /** 性別の文字列を数値に変換 */
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
                val errorMsg: String = "Gender string is invalid:$genderString"
                throw IllegalStateException(errorMsg)
            }
        }
    }
}