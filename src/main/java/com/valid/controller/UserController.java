package com.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.valid.binding.User;

import jakarta.validation.Valid;

@Controller
public class UserController {
     @GetMapping("/")
	public String loadForm(Model model)
	{
		model.addAttribute("user", new User());
		
		return "index";
	}
     
     @PostMapping("/user")
 	public String handleForm(@Valid User user,BindingResult result ,Model model)
 	{
    	 //validation failed
    	 if(result.hasErrors())
    	 {
    		 return "index";
    	 }
    	 //validation success
    	 else
    	 {
    	 System.out.println(user);
 		model.addAttribute("msg", "user saved");
 		//logic
 		return "index";
    	 }
 	}
     
     
     
     
}
