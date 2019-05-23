package com.leansecurity.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView indexAdmin() {
		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = userService.findByEmail(auth.getName());
//		modelAndView.addObject("userName", "Welcome " + user.getUsername() + " " + " (" + user.getEmail() + ")");
//		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/index");
		return modelAndView;
	}

	@RequestMapping("/admin/pages-profile")
	public ModelAndView profile() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/pages-profile");
		return mv;
	}
}
