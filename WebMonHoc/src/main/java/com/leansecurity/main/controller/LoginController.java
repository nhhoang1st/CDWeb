package com.leansecurity.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leansecurity.main.model.CheckEmail;
import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.service.UserServiceImp;

@Controller
public class LoginController {

	@Autowired
	private UserServiceImp userService;
	@Autowired
	private UserRepository ur;

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
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
		modelAndView.setViewName("registration");

		return modelAndView;
	}


	
}