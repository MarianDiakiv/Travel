package ua.springweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.springweb.entity.UserEntity;
import ua.springweb.mapper.UserMapper;
import ua.springweb.repository.UserRepository;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity entity = userRepository.findUserForAutentication(email);
		
		if(entity==null)throw new UsernameNotFoundException("USER Not Found");
		return UserMapper.toSecurityUser(entity);
	}

}
