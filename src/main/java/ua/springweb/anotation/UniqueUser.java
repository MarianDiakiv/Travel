package ua.springweb.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.springweb.validator.UniqueUserForRegistration;


@Target(value= {ElementType.FIELD, ElementType.METHOD})
@Retention(value=RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserForRegistration.class)
public @interface UniqueUser {

	String message() default "This User Exist";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
