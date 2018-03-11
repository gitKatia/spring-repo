package com.kat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Welcome to the Spring Web App");
		return "welcome";
	}

}
