package ua.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.springweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	UserEntity findUserForAutentication(@Param("email") String email);
	
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	UserEntity findUserByEmail(@Param("email") String email);

}
