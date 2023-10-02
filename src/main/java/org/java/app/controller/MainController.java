package org.java.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(Model model) {
		String name = "Mattia";
		
		model.addAttribute("name", name);
		
		return "home";
	}
}
