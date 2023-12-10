package com.example.demo.validator

import io.micrometer.common.util.StringUtils
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersInvalidException
import org.springframework.batch.core.JobParametersValidator

class RequiredValidator: JobParametersValidator {
    override fun validate(parameters: JobParameters?) {
        // パラメータ取得
        val key = "require1"
        val require1: String? = parameters?.getString(key)

        // 必須入力チェック
        if(StringUtils.isEmpty(require1)){
            val errorMsg = "Not entered: $key"
            throw JobParametersInvalidException(errorMsg)
        }
    }
}
