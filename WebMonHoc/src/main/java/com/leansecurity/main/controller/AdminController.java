package com.leansecurity.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.service.UserServiceImp;

@Controller
public class AdminController {
	
	@Autowired
	private UserServiceImp userService;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView indexAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("accountName", user.getUsername());
		modelAndView.addObject("accountEmail", user.getEmail());
		modelAndView.setViewName("admin/index");
		return modelAndView;
	}

	@RequestMapping("/admin/pages-profile")
	public ModelAndView profile() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("accountName", user.getUsername());
		modelAndView.addObject("accountEmail", user.getEmail());
		modelAndView.addObject("accountDetail", user);
		modelAndView.setViewName("admin/pages-profile");
		return modelAndView;
	}
	
//	@RequestMapping("/layout")
//	public ModelAndView layout() {
//		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = userService.findByEmail(auth.getName());
//		modelAndView.addObject("accountName", user);
//		modelAndView.setViewName("layout");
//		return modelAndView;
//	}
}
