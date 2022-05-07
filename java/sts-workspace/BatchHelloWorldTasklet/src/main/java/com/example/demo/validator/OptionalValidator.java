package com.example.demo.validator;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.util.StringUtils;

public class OptionalValidator implements JobParametersValidator {
	@SuppressWarnings("deprecation")
	@Override
	public void validate(JobParameters parameters) throws JobParametersInvalidException {
		// パラメータ取得
		String key = "option1";
		String option1 = parameters.getString(key);
		
		// 存在チェック
		if(StringUtils.isEmpty(option1)) {
			return;
		}
		
		// 型チェック
		try {
			Integer.parseInt(option1);
		} catch (NumberFormatException e) {
			String errorMsg = "Not Number: value=" + option1;
			throw new JobParametersInvalidException(errorMsg);
		}
	}
}
