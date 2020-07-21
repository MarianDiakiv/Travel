package ua.springweb.service.service;

import ua.springweb.entity.UserEntity;

public interface UserServise {
	void saveUser(UserEntity entity);
	UserEntity findUserByEmail(String email);
	UserEntity findUserByID(int id);

}
