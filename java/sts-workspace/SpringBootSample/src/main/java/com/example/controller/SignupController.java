package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;

@Controller
@RequestMapping("/user")
public class SignupController {

	@Autowired
	private UserApplicationService userApplicationService;
	
	/** ユーザ登録画面を表示 */
	@GetMapping("/signup")
	public String getSignup(Model model) {
		// 性別を取得
		Map<String, Integer>genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		
		// ユーザ登録画面に遷移
		return "user/signup";
	}
	
	/** ユーザ登録処理 */
	@PostMapping("/signup")
	public String postSignUp() {
		// ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
