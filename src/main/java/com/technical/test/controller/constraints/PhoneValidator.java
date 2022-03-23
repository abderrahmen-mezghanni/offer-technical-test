package com.technical.test.controller.constraints;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public boolean isValid(final String phone, ConstraintValidatorContext context) {
		if (phone == null || phone.length() == 0) {
			return true;
		}
		String phoneRegEx = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";
		return Pattern.matches(phoneRegEx, phone);
	}
}
