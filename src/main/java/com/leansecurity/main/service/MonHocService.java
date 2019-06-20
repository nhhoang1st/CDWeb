package com.leansecurity.main.service;

import java.util.List;

import com.leansecurity.main.model.MonHoc;
import com.leansecurity.main.model.User;

public interface MonHocService {
	void saveMonHoc(MonHoc monhoc,  int idgv);
	void addListUser(int idmh, List<Integer>listId);
}
