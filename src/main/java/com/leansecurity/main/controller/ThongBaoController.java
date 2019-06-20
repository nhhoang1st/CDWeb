package com.leansecurity.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leansecurity.main.model.ThongBao;
import com.leansecurity.main.repository.ThongBaoRepository;
import com.leansecurity.main.service.ThongBaoService;
import com.leansecurity.main.serviceImp.ThongBaoServiceImp;

@Controller
public class ThongBaoController {
	@Autowired
	private ThongBaoRepository thongBaoRepository;
	@Autowired
	private ThongBaoService thongBaoService;
	@Autowired
	private ThongBaoServiceImp thongBaoServiceImp;
	
	@PostMapping(value = "/admin/addThongBao")
	public String createMH(@Valid ThongBao thongBao,@RequestParam int id_mh, RedirectAttributes redirect) {
		thongBaoServiceImp.saveTB(thongBao,id_mh);
		return "redirect:/webapp/index";
	}
	@GetMapping("/admin/{id}/deleteTb")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		thongBaoRepository.deleteById(id);
		redirect.addFlashAttribute("success", "alert('Xóa thành công')");
		return "redirect:/webapp/index";
	}
}
