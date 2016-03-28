package com.killpekeinside.controller;

import com.killpekeinside.data.dto.UserAuthDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

	@RequestMapping (value = "/")
	public String home(@AuthenticationPrincipal UserAuthDto userDetail, Model model) {
		model.addAttribute("user", userDetail);
		return "home";
	}

	@RequestMapping (value = "/error")
	public String error(@RequestParam String message, Model model) {
		model.addAttribute("message", message);
		return "error";
	}
}
