package com.leansecurity.main.service;

import com.leansecurity.main.model.UpdateUser;
import com.leansecurity.main.model.User;

public interface UserService {
	void save(User user);

	User findByEmail(String email);

	boolean existsByEmail(String email);
	boolean update(UpdateUser user);
	boolean updateAnh(int id, String anh);
}
