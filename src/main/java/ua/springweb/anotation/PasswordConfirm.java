package ua.springweb.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.springweb.validator.PasswordConfirmValidator;
import ua.springweb.validator.UniqueUserForRegistration;

@Target(value= ElementType.TYPE)
@Retention(value=RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConfirmValidator.class)
public @interface PasswordConfirm {
	
	String message() default "EROR";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};

}
