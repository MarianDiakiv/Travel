package ua.springweb.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.springweb.domain.RegisretRequest;
import ua.springweb.entity.UserEntity;
import ua.springweb.entity.enumeration.Role;

public interface UserMapper {
	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(), entity.getPassword(), 
				AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	public static UserEntity registerToUser(RegisretRequest request) {
		UserEntity user = new UserEntity();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(Role.ROLE_USER);
		
		return user;
	}
	
}
