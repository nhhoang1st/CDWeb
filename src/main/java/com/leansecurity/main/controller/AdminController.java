package com.leansecurity.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.leansecurity.main.model.MonHoc;
import com.leansecurity.main.model.ThongBao;
import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.MonHocRepository;
import com.leansecurity.main.repository.ThongBaoRepository;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.serviceImp.UserServiceImp;

@Controller
public class AdminController {

	@Autowired
	private UserServiceImp userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MonHocRepository monHocRepository;
	@Autowired
	private ThongBaoRepository thongBaoRepository;

	@RequestMapping(value = "/webapp/index", method = RequestMethod.GET)
	public ModelAndView indexAdmin() {
		ModelAndView modelAndView = new ModelAndView();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("accountName", user.getUsername());
		modelAndView.addObject("accountEmail", user.getEmail());
		modelAndView.addObject("accountDetail", user);
		modelAndView.addObject("newTB", new ThongBao());
		// list mon hoc
		List<MonHoc> listMh = monHocRepository.findAll();
		List<MonHoc> listMhbyUser = new ArrayList<MonHoc>();
		for (MonHoc mh : listMh) {
			for (User u : mh.getUsers()) {
				if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
					listMhbyUser.add(mh);
				}
			}
		}
		modelAndView.addObject("listMh", listMhbyUser);
		// list thong bao
		List<ThongBao> listTb = new ArrayList<ThongBao>();
		for (MonHoc mh : listMhbyUser) {
			for (ThongBao thongBao : mh.getListTB()) {
				listTb.add(thongBao);
			}
		}
		modelAndView.addObject("listTB", listTb);
		modelAndView.setViewName("/webapp/index");
		return modelAndView;
	}

	@RequestMapping("/webapp/pages-profile")
	public ModelAndView profile() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("accountName", user.getUsername());
		modelAndView.addObject("accountEmail", user.getEmail());
		modelAndView.addObject("accountDetail", user);
		modelAndView.setViewName("webapp/pages-profile");
		return modelAndView;
	}

}
