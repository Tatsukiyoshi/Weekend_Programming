package com.example.demo.validator

import io.micrometer.common.util.StringUtils
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersInvalidException
import org.springframework.batch.core.JobParametersValidator

class OptionalValidator: JobParametersValidator {
    override fun validate(parameters: JobParameters?) {
        // パラメータ取得
        val key = "option1"
        val option1: String? = parameters?.getString(key)

        // 存在チェック
        if(StringUtils.isEmpty(option1)){
            return
        }

        // 型チェック
        try {
            option1?.toInt() // 文字列から数字への変換
        } catch (e: NumberFormatException){
            val errorMsg = "Not Number: value=$option1"
            throw JobParametersInvalidException(errorMsg)
        }
    }
}
