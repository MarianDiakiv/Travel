package ua.springweb.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ua.springweb.anotation.PasswordConfirm;
import ua.springweb.domain.RegisretRequest;

public class PasswordConfirmValidator implements ConstraintValidator<PasswordConfirm, RegisretRequest> {

	@Override
	public void initialize(PasswordConfirm constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(RegisretRequest user, ConstraintValidatorContext context) {
		
		if(user.getPassword()==null||user.getPasswordConfirmation()==null) {
			return false;
		}
		if(user.getPassword().equals(user.getPasswordConfirmation())) {
			return true;
		}
		return false;
	}

}
