package com.example.demo.domain.model

import lombok.Data

@Data
class Employee {
    private var id: Int = 0
    private var name: String? = null
    private var age: Int = 0
    private var gender: Int = 0
    private var genderString: String? = null

    /** 性別の数値を文字列に変換 */
    fun convertGenderIntToString(){
        // 数値を文字列に変換
        if(gender == 1){
            genderString = "男性"
        } else if(gender == 2){
            genderString = "女性"
        } else {
            val errorMsg: String = "Gender is invalid:$gender"
            throw IllegalStateException(errorMsg)
        }
    }
}
