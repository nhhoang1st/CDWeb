package com.leansecurity.main.service;

import com.leansecurity.main.model.User;

public interface UserService {
	void save(User user);
	 User findByEmail(String email);
}
