package com.leansecurity.main.serviceImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leansecurity.main.model.MonHoc;
import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.MonHocRepository;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.service.MonHocService;

@Service
public class MonHocServiceImp implements MonHocService {
	@Autowired
	private MonHocRepository monhocRep;
	@Autowired
	private UserRepository userRep;

	@Override
	public void saveMonHoc(MonHoc monhoc, int idgv) {
		User user = userRep.getOne(idgv);
		monhoc.setUsers(new ArrayList<User>(Arrays.asList(user)));
		monhocRep.save(monhoc);

	}

	@Override
	public void addListUser(int idmh, List<Integer> listId) {
//		MonHoc mh = monhocRep.findMonHocById(idmh);
//		for (Integer i : listId) {
//			Optional<User> user = userRep.findById(i);
//		//	mh.setUsers(new HashSet<User>(Arrays.asList((user)));
//		}
		
	}

}
