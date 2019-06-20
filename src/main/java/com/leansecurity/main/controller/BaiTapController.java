package com.leansecurity.main.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leansecurity.main.model.BaiTap;
import com.leansecurity.main.model.FileBaiTap;
import com.leansecurity.main.model.MonHoc;
import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.BaiTapRepository;
import com.leansecurity.main.repository.MonHocRepository;
import com.leansecurity.main.repository.ThongBaoRepository;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.serviceImp.BaiTapServiceImp;
import com.leansecurity.main.serviceImp.UserServiceImp;
import com.leansecurity.main.utils.DownloadFile;

@Controller
public class BaiTapController {
	
	@Autowired
	private UserServiceImp userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MonHocRepository monHocRepository;
	@Autowired
	private ThongBaoRepository thongBaoRepository;
	@Autowired
	private BaiTapRepository baiTapRepository;
	@Autowired
	private BaiTapServiceImp baiTapServiceImp;
	
	@RequestMapping("/webapp/deadline")
	public ModelAndView deadlinePage() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("accountName", user.getUsername());
		modelAndView.addObject("accountEmail", user.getEmail());
		modelAndView.addObject("accountDetail", user);
		modelAndView.addObject("newBT", new BaiTap());
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
		
		List<BaiTap> listBt = new ArrayList<BaiTap>();
		for (MonHoc mh : listMhbyUser) {
			abc : for (BaiTap baiTap : mh.getListBT()) {
				for (FileBaiTap f : baiTap.getListFileBT()) {
					if(f.getUser().getIduser() == user.getIduser()) {
						continue abc;
					}
				}
				listBt.add(baiTap);
			}
		}
		modelAndView.addObject("listBt", listBt);
		
		
		modelAndView.setViewName("webapp/deadline");
		return modelAndView;
	}
	@PostMapping(value = "/admin/addBaiTap")
	public String createMH(@Valid BaiTap baiTap,@RequestParam int id_mh, RedirectAttributes redirect) {
		baiTapServiceImp.saveBt(baiTap,id_mh);
		return "redirect:/webapp/deadline";
	}
	@GetMapping("/admin/{id}/deleteBt")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		baiTapRepository.deleteById(id);
		redirect.addFlashAttribute("success", "alert('Xóa thành công')");
		return "redirect:/webapp/deadline";
	}
	

	@RequestMapping(value = "/admin/{id}/downloadBt", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> download2(HttpServletRequest request,@PathVariable int id) throws IOException {
	    HttpHeaders responseHeader = new HttpHeaders();
	    try {
	    	//Nen thu muc bai tap thanh zip
	    	DownloadFile downloadFile = new DownloadFile();
	    	
	    	String folderPath = request.getServletContext().getRealPath("folderBaiTap\\"+baiTapRepository.findById(id).get().getFolder());
	    	
	    	String zipDirName = request.getServletContext().getRealPath("folderBaiTap\\"+baiTapRepository.findById(id).get().getFolder())+".zip";
	    	
	    	System.out.println("-----------------foleder zip:"+folderPath);
	    	System.out.println("-----------------name zip:"+zipDirName);
	    	
	    	downloadFile.zipDirectory(folderPath, zipDirName);
	    	
	    	
	      File file = new File(zipDirName);
	      System.out.println(file.length());
	      
	      
	      byte[] data = FileUtils.readFileToByteArray(file);
	      // Set mimeType trả về
	      responseHeader.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	      // Thiết lập thông tin trả về
	      responseHeader.set("Content-disposition", "attachment; filename=" + file.getName());
	      responseHeader.setContentLength(data.length);
	      InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
	      InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
	      
	      System.out.print("--------------------Thoong tin :"+file.getPath());
	      
	      return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeader, HttpStatus.OK);
	      
	    } catch (Exception ex) {
	      return new ResponseEntity<InputStreamResource>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	}
	
	 

}
