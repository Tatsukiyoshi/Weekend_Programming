package com.example.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
	@Autowired
	private MessageSource messageSource;
	
	/** 性別のMapを生成する */
	public Map<String, Integer> getGenderMap(){
		String male=messageSource.getMessage("male", null, Locale.JAPAN);
		String female=messageSource.getMessage("female", null, Locale.JAPAN);
		
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		genderMap.put(male, 1);
		genderMap.put(female, 2);
		return genderMap;
	}
}
