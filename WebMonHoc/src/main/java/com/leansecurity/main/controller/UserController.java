package com.leansecurity.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
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
