package com.leansecurity.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leansecurity.main.model.AjaxResponseBody;
import com.leansecurity.main.model.MonHoc;
import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.MonHocRepository;
import com.leansecurity.main.repository.RoleRepository;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.serviceImp.MonHocServiceImp;
import com.leansecurity.main.serviceImp.UserServiceImp;

@Controller
public class KhoaHocController {
	
	@Autowired
	private MonHocServiceImp monHocService;
	@Autowired
	private UserServiceImp userService;
	@Autowired
	private MonHocRepository monHocRepository;
	@Autowired
	private UserRepository ur;
	@Autowired
	private RoleRepository roleRepository;


	@RequestMapping(value = "/admin/addmonhoc", method = RequestMethod.GET)
	public ModelAndView monhoc() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("monhoc", new MonHoc());
		modelAndView.setViewName("webapp/khoahoc");
		return modelAndView;
	}
	@RequestMapping("/webapp/khoahoc")
	public ModelAndView khoahocPage() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("accountName", user.getUsername());
		modelAndView.addObject("accountEmail", user.getEmail());
		modelAndView.addObject("accountDetail", user);
		modelAndView.addObject("monhoc", new MonHoc());
		List<MonHoc> listMh = monHocRepository.findAll();
		
		List<MonHoc> listMhbyUser = new ArrayList<MonHoc>();
		for (MonHoc mh : listMh) {
			for (User u : mh.getUsers()) {
				if(u.getEmail().equalsIgnoreCase(user.getEmail())) {
					listMhbyUser.add(mh);
				}
			}
		}
		modelAndView.addObject("listMh", listMhbyUser);
		
		List<MonHoc> listMhbyUser2 = new ArrayList<MonHoc>();
	for1 : 	for (MonHoc mh : listMh) {
			for (User u : mh.getUsers()) {
				if(u.getEmail().equalsIgnoreCase(user.getEmail())) {
					continue for1;
				}
			}
			listMhbyUser2.add(mh);
			
		}
		modelAndView.addObject("listAllMh", listMhbyUser2);
		modelAndView.setViewName("webapp/khoahoc");
		return modelAndView;
	}
	@PostMapping(value = "/admin/addmonhoc")
	public String createMH(@Valid MonHoc monhoc, RedirectAttributes redirect) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		monHocService.saveMonHoc(monhoc, user.getIduser());
		return "redirect:/webapp/khoahoc";
	}
	
	@GetMapping("/admin/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		monHocRepository.deleteById(id);
		redirect.addFlashAttribute("success", "alert('Xóa thành công')");
		return "redirect:/webapp/khoahoc";
	}
	@PostMapping("/admin/checkadd")
	public ResponseEntity<?> checkAdd() {
		AjaxResponseBody result = new AjaxResponseBody();
		if (true) {
			result.setMes("true");;
			result.setResult(null);
		} else {
			result.setMes("false");;
			result.setResult(null);
		}
		return ResponseEntity.ok(result);
	}

}
