package com.leansecurity.main.serviceImp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leansecurity.main.model.Role;
import com.leansecurity.main.model.UpdateUser;
import com.leansecurity.main.model.User;
import com.leansecurity.main.repository.RoleRepository;
import com.leansecurity.main.repository.UserRepository;
import com.leansecurity.main.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(0);
		user.setAddress("");
		user.setImage("");
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean existsByEmail(String email) {
		for (User u : userRepository.findAll()) {
			if(u.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean update(UpdateUser user) {
		if(user == null) return false;
		Optional<User> us =userRepository.findById(user.getID());
		User u = us.get();
		if(user.getName()!="")u.setUsername(user.getName());
		if(user.getEmail()!="")u.setEmail(user.getEmail());
		if(user.getSdt()!="")u.setPhonenumber(user.getSdt());
		if(user.getDC()!="")u.setAddress(user.getDC());
		userRepository.save(u);
		return true;
	}

	@Override
	public boolean updateAnh(int id, String anh) {
		
		User u =userRepository.findById(id).get();
		u.setImage(anh);
		userRepository.save(u);
		return true;
	}


}