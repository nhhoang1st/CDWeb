package com.leansecurity.main.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.leansecurity.main.model.AjaxResponseBody;
import com.leansecurity.main.model.AjaxResponseBody2;
import com.leansecurity.main.model.BaiTap;
import com.leansecurity.main.model.CheckAjax;
import com.leansecurity.main.model.CheckAjaxDouble;
import com.leansecurity.main.model.FileBaiTap;
import com.leansecurity.main.model.FormNopBaiAjax;
import com.leansecurity.main.model.MonHoc;
import com.leansecurity.main.model.MonHocAjax;
import com.leansecurity.main.model.MyUpLoadForm;
import com.leansecurity.main.model.ThongBao;
import com.leansecurity.main.model.UpdateUser;
import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.BaiTapRepository;
import com.leansecurity.main.repository.MonHocRepository;
import com.leansecurity.main.repository.ThongBaoRepository;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.service.FileBaiTapRepository;
import com.leansecurity.main.serviceImp.MonHocServiceImp;
import com.leansecurity.main.serviceImp.UserServiceImp;

@Controller
public class AjaxController {
	@Autowired
	private UserServiceImp userService;
	@Autowired
	private UserRepository ur;
	@Autowired
	private MonHocRepository mhRepository;
	@Autowired
	private MonHocServiceImp monHocServiceImp;
	@Autowired
	private BaiTapRepository baiTapRepository;
	@Autowired
	private FileBaiTapRepository fileBaiTapRepository;
	@Autowired
	private ThongBaoRepository thongBaoRepository;

	@PostMapping("/checkEmail")
	public ResponseEntity<?> checkEmail(@RequestBody CheckAjax email) {
		AjaxResponseBody result = new AjaxResponseBody();
		if (userService.existsByEmail(email.getValue())) {
			result.setMes("true");
			;
			result.setResult(null);
		} else {
			result.setMes("false");
			;
			result.setResult(null);
		}
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/getDetail")
	public ResponseEntity<?> getDetail(@RequestBody CheckAjax value) {
		AjaxResponseBody result = new AjaxResponseBody();
		System.out.println(value.getValue());
		MonHoc mh = mhRepository.findById(Integer.parseInt(value.getValue())).get();
		
		MonHocAjax monHocAjax = new MonHocAjax();
		monHocAjax.setTenmh(mh.getTenmh());
		monHocAjax.setMucmh(mh.getMucmh());
		monHocAjax.setMota(mh.getMota());
		monHocAjax.setTenrutgon(mh.getTenrutgon());
		monHocAjax.setNgaybd(mh.getNgaybd());
		monHocAjax.setNgaykt(mh.getNgaykt());
		monHocAjax.setSoThanhVien(mh.getUsers().size()-1);
		monHocAjax.setSoThongBao(mh.getListTB().size());
		monHocAjax.setSoBaiTap(mh.getListBT().size());
		
		return new ResponseEntity<MonHocAjax>(monHocAjax, HttpStatus.OK);
	}
	
	@PostMapping("/getDetailTb")
	public ResponseEntity<?> getDetailTb(@RequestBody CheckAjax value) {
		AjaxResponseBody result = new AjaxResponseBody();
		System.out.println(value.getValue());
		ThongBao thongBao = thongBaoRepository.findById(Integer.parseInt(value.getValue())).get();
		
		MonHocAjax monHocAjax = new MonHocAjax();
		monHocAjax.setTenmh(thongBao.getTieude());
		monHocAjax.setMota(thongBao.getNoidung());
		monHocAjax.setNgaybd(thongBao.getNgaytb());
		
		
		return new ResponseEntity<MonHocAjax>(monHocAjax, HttpStatus.OK);
	}
	
	@PostMapping("/joinClass")
	public ResponseEntity<?> joinClass(@RequestBody CheckAjaxDouble value) {
		AjaxResponseBody result = new AjaxResponseBody();
		MonHoc monhoc = mhRepository.findById(Integer.parseInt(value.getIdMonhoc())).get();
		User user = ur.findById(Integer.parseInt(value.getIdUser())).get();
		List<User> listUser = monhoc.getUsers();
		listUser.add(user);
		monhoc.setUsers(listUser);
		mhRepository.save(monhoc);
		result.setMes("true");
		return new ResponseEntity<AjaxResponseBody>(result, HttpStatus.OK);
	}

	@PostMapping("/updateUser")
	public ResponseEntity<?> checkEmail(@RequestBody UpdateUser user) {
		AjaxResponseBody result = new AjaxResponseBody();
		if (userService.update(user)) {
			result.setMes("true");
		} else {
			result.setMes("false");
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/updateAnh")
	public ResponseEntity<?> updateAnh(@ModelAttribute MyUpLoadForm uploadForm, HttpServletRequest request) {
		System.out.println(uploadForm);
		AjaxResponseBody result = new AjaxResponseBody();
		String anh = doUpLoad(request, uploadForm);
		System.out.println("linh anh: " + anh);
		if (anh != null) {
			if (userService.updateAnh(uploadForm.getId(), anh)) {
				System.out.println("update thành công!");
				result.setMes(anh);
			}
		}

		return ResponseEntity.ok(result);
	}
	@PostMapping("/nopBai")
	public ResponseEntity<?> nopBai(@ModelAttribute FormNopBaiAjax uploadForm, HttpServletRequest request) {
		System.out.println(uploadForm);
		AjaxResponseBody result = new AjaxResponseBody();
		BaiTap baiTap = baiTapRepository.findById(Integer.parseInt(uploadForm.getIdBaiTap())).get();
		String folderPath = baiTap.getFolder();
		String s = doUpLoadBT(request, uploadForm, folderPath);
		
		FileBaiTap fileBt = new FileBaiTap();
		fileBt.setBaitap(baiTap);
		fileBt.setFilepath("../folderBaiTap/"+folderPath+"/"+uploadForm.getFileData().getOriginalFilename());
		fileBt.setUser(ur.findById(Integer.parseInt(uploadForm.getIdUser())).get());
		fileBaiTapRepository.save(fileBt);
		result.setMes(s);
		return ResponseEntity.ok(result);
	}

	private String doUpLoad(HttpServletRequest request,  MyUpLoadForm myUploadForm) {
		String result = null;
		String uploadRootPath = request.getServletContext().getRealPath("upload");
		System.out.println("=================roor: "+uploadRootPath);
        System.out.println("uploadRootPath=" + uploadRootPath);
        File uploadRootDir = new File(uploadRootPath);
        
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
		
        MultipartFile fileData = myUploadForm.getFileData();
        String name = fileData.getOriginalFilename();
        System.out.println("file tai len:" + name);
        result="../upload/" + name;
        
        if (name != null && name.length() > 0) {
            try {
                // Tạo file tại Server.
                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(fileData.getBytes());
                
                stream.close();
               
                // 
                
                System.out.println("Write file: " + serverFile);
                System.out.println("upload Thành công!");
            } catch (Exception e) {
                System.out.println("Error Write file: " + name);
                System.out.println("upLoad thất bại!");
               
                
            }
        }
        
        
        
        
		return result;
	}
	private String doUpLoadBT(HttpServletRequest request, FormNopBaiAjax uploadForm, String folderPath) {
		String result = null;
		String uploadRootPath = request.getServletContext().getRealPath("folderBaiTap//");
		System.out.println("uploadRootPath=" + uploadRootPath);
		File uploadRootDir = new File(uploadRootPath+folderPath);
		
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		
		
		MultipartFile fileData = uploadForm.getFileData();
		String name = fileData.getOriginalFilename();
		System.out.println("file tai len:" + name);
		result = "true";

		if (name != null && name.length() > 0) {
			try {
				// Tạo file tại Server.
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(fileData.getBytes());

				stream.close();

				//

				System.out.println("Write file: " + serverFile);
				System.out.println("upload Thành công!");
			} catch (Exception e) {
				System.out.println("Error Write file: " + name);
				System.out.println("upLoad thất bại!");

			}
		}

		return result;
	}
	
	@PostMapping("/updateMonHocc")
	public ResponseEntity<?> updateMonhoc(@RequestBody int id) {
		System.out.println("id user la:" + id);
		AjaxResponseBody2 result = new AjaxResponseBody2();
		Optional<User> er = ur.findById(id);
		User user = er.get();
		List<MonHoc> listMh = mhRepository.findAll();
		
		List<MonHoc> listMhbyUser = new ArrayList<MonHoc>();
		for (MonHoc mh : listMh) {
			for (User u : mh.getUsers()) {
				if(u.getEmail().equalsIgnoreCase(user.getEmail())) {
					listMhbyUser.add(mh);
				}
			}
		}
		
		
		List<MonHoc> listMhbyUser2 = new ArrayList<MonHoc>();
	for1 : 	for (MonHoc mh : listMh) {
			for (User u : mh.getUsers()) {
				if(u.getEmail().equalsIgnoreCase(user.getEmail())) {
					continue for1;
				}
			}
			listMhbyUser2.add(mh);
			
		}
		show(listMhbyUser);
		result.setUser(user);
		result.setDatg(listMhbyUser);
		result.setChuatg(listMhbyUser2);

		return ResponseEntity.ok(result);
	}
	public void show(List<MonHoc> list) {
		for(MonHoc u :list) {
			System.out.println(u.getTenmh());
		}
	}


}
