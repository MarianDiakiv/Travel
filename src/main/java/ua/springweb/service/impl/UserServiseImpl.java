package ua.springweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.springweb.entity.UserEntity;
import ua.springweb.repository.UserRepository;
import ua.springweb.service.service.UserServise;

@Service
public class UserServiseImpl implements UserServise {

	@Autowired
	public UserServiseImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void saveUser(UserEntity entity) {
		String password  = entity.getPassword();
		System.out.println( "BEFORE "+password);
		entity.setPassword(passwordEncoder.encode(password));
		System.out.println("AFTER " + entity.getPassword());
		userRepository.save(entity);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmail(email);
	}

	@Override
	public UserEntity findUserByID(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
