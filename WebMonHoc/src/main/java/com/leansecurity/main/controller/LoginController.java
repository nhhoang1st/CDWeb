package com.leansecurity.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.service.UserServiceImp;

@RestController
public class LoginController {

	@Autowired
	private UserServiceImp userService;
	@Autowired
	private UserRepository ur;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration")
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, RedirectAttributes redirect) {
		ModelAndView modelAndView = new ModelAndView();
		userService.save(user);
		redirect.addFlashAttribute("successMessage", "Đăng ký tài khoản thành công");
		modelAndView.addObject("successMessage", "Đăng ký tài khoản thành công");
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("redirect:/login");

		return modelAndView;
	}

//	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
//	public ModelAndView home() {
//		ModelAndView modelAndView = new ModelAndView();
////		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////		User user = userService.findByEmail(auth.getName());
////		modelAndView.addObject("userName", "Welcome " + user.getUsername() + " " + " (" + user.getEmail() + ")");
//		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//		modelAndView.setViewName("admin/home");
//		return modelAndView;
//	}
//	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
//	public ModelAndView indexAdmin() {
//		ModelAndView modelAndView = new ModelAndView();
////		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////		User user = userService.findByEmail(auth.getName());
////		modelAndView.addObject("userName", "Welcome " + user.getUsername() + " " + " (" + user.getEmail() + ")");
////		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//		modelAndView.setViewName("admin/index");
//		return modelAndView;
//	}


}