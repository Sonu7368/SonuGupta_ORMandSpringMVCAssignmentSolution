package com.greatlearning.crm_assignment.controller;

import org.springframework.core.io.ResourceEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:customer/list";
//		System.out.println("print in home");
//		return "home";
	}
	
}
