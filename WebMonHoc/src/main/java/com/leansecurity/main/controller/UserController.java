package com.leansecurity.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.leansecurity.main.model.CheckEmail;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.service.UserServiceImp;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImp userService;
	@Autowired
	private UserRepository ur;
	
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView indexUser() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/index");
		return modelAndView;
	}

	@RequestMapping("/user/pages-profile")
	public ModelAndView profileUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/pages-profile");
		return mv;
	}
	
}
