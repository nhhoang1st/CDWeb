package com.leansecurity.main.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leansecurity.main.model.BaiTap;
import com.leansecurity.main.model.MonHoc;
import com.leansecurity.main.repository.BaiTapRepository;
import com.leansecurity.main.repository.MonHocRepository;
import com.leansecurity.main.service.BaiTapService;

@Service
public class BaiTapServiceImp implements BaiTapService{
	
	@Autowired
	private MonHocRepository monHocRepository;
	@Autowired
	private BaiTapRepository baiTapRepository;
	
	@Override
	public void saveBt(BaiTap baiTap, int id_mh) {
		MonHoc mh = monHocRepository.findById(id_mh).get();
		baiTap.setMonhoc(mh);
		baiTapRepository.save(baiTap);
		
		
	}

}
