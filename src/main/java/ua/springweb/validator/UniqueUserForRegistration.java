package ua.springweb.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springweb.anotation.UniqueUser;
import ua.springweb.service.service.UserServise;


@Component
public class UniqueUserForRegistration implements ConstraintValidator<UniqueUser, String> {

	@Autowired
	UserServise userServise;
	@Override
	public void initialize(UniqueUser constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if(userServise.findUserByEmail(email)!=null) {
			return false;
		}else {
			return true;
		}
	}
		
	

}
