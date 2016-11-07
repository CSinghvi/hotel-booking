/**
 * 
 */
package com.mindtree.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.dto.LoginDetails;



/**
 * @author M1035998
 *
 */
@Component
public class LoginValidator implements Validator {
	private Pattern pattern;
	private Matcher matcher;
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "email", "error.email.required", "Email Cannot be Empty");
		ValidationUtils.rejectIfEmpty(e, "password", "error.password.required", "Password Cannot be Empty");
		
		LoginDetails login=(LoginDetails) obj;
		String email=login.getEmail();
		String password=login.getPassword();
		
		
		final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile( EMAIL_PATTERN);
		matcher = pattern.matcher(login.getEmail());
		
		if (!matcher.matches()){
			e.rejectValue("email", "email.incorrect", "incorrect email address");

			
		}
		
		
		if(password.length()<5&&password.length()>15){
			e.rejectValue("password", "password.incorrect", "Your password must between 6 and 15 characters");

		}
		
		
		
	}

}