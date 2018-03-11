package com.kat.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kat.model.Country;
import com.kat.model.User;

@Controller
public class UserController {
	
	@ModelAttribute("countries")
	public List<Country> countries() {
		List<Country> countries = new ArrayList<Country>();
		countries.add(new Country("IT","Italy"));
		countries.add(new Country("DE","Germany"));
		countries.add(new Country("EN","United Kingdom"));
		countries.add(new Country("FR","France"));
		return countries;
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String getUserForm(Model model){
		
		model.addAttribute("user", new User());
		return "userForm";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") User user, 
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "userForm";
		} else {
			//Add further validation on fields. Only alpha numeric
			model.addAttribute("user", user);
			return "userSuccess";
		}
	}

}
