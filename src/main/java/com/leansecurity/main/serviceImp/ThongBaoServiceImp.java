package com.leansecurity.main.serviceImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leansecurity.main.model.MonHoc;
import com.leansecurity.main.model.ThongBao;
import com.leansecurity.main.repository.MonHocRepository;
import com.leansecurity.main.repository.ThongBaoRepository;
import com.leansecurity.main.service.ThongBaoService;

@Service
public class ThongBaoServiceImp implements ThongBaoService{
	@Autowired
	private ThongBaoRepository tb;
	@Autowired
	private MonHocRepository monHocRepository;
	@Override
	public void saveTB(ThongBao thongBao, int id_mh) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		thongBao.setNgaytb(dtf.format(localDate));
		Optional<MonHoc> opMonHoc = monHocRepository.findById(id_mh);
		MonHoc monHoc = opMonHoc.get();
		thongBao.setMonhoc(monHoc);
		thongBao.setFilepath("");
		tb.save(thongBao);
	}
	
}
