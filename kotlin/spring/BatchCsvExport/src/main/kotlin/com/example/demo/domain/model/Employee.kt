package com.example.demo.domain.model

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Id

@Data
@Entity
open class Employee {
    @Id
    open var id: Int = 0
    open var name: String? = null
    open var age: Int = 0
    open var gender: Int = 0
    @Transient
    open var genderString: String? = null

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
