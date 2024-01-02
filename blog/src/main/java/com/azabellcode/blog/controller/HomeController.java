package com.azabellcode.blog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.Authentication;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	@Value("${project.name}")
	String projectName;

	@GetMapping("/customAlert")
	public String customAlertHome(Model model) {
		model.addAttribute("site_title", projectName);
		return "thymeleaf/customAlert";
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("site_title", projectName);
		return "thymeleaf/index";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("site_title", projectName);
		return "thymeleaf/index";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("site_title", projectName);
		return "thymeleaf/about";
	}

	@GetMapping("/404")
	public String errorHtml(Model model) {
		model.addAttribute("site_title", projectName);
		return "thymeleaf/404";
	}

	@GetMapping("/login")
	public String login(Model model, @RequestParam(required = false) String error, Authentication authentication) {
		model.addAttribute("site_title", projectName);

		// Spring Security의 Authentication 객체를 이용하여 로그인 상태 확인
		if (authentication != null && authentication.isAuthenticated()) {
			return "redirect:/index"; // 이미 로그인한 경우 다른 페이지로 리다이렉트
		}

		model.addAttribute("site_title", projectName);
		if (error != null) {
			model.addAttribute("loginError", true);
		}
		return "thymeleaf/login";
	}

	@PostMapping("/logout")
	@ResponseBody
	public String logout() {
		// 로그아웃
		return "Logged out successfully!";
	}

	/* */

}
