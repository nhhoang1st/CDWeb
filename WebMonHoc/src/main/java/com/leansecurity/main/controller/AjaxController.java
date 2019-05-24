package com.leansecurity.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.leansecurity.main.model.AjaxResponseBody;
import com.leansecurity.main.model.CheckEmail;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.service.UserServiceImp;

@Controller
public class AjaxController {
	@Autowired
	private UserServiceImp userService;
	@Autowired
	private UserRepository ur;

	@PostMapping("/checkEmail")
	public ResponseEntity<?> checkEmail(@RequestBody CheckEmail email) {
		AjaxResponseBody result = new AjaxResponseBody();
		if (userService.existsByEmail(email.getEmail())) {
			result.setMes("true");;
			result.setResult(null);
		} else {
			result.setMes("false");;
			result.setResult(null);
		}
		return ResponseEntity.ok(result);
	}

}
