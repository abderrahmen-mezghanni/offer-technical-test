package com.technical.test.controller.constraints;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, String> {

	@Override
	public boolean isValid(final String valueToValidate, ConstraintValidatorContext context) {
		if (valueToValidate == null || valueToValidate.length() == 0) {
			return true;
		}
	    String[] genderList = {"MALE", "FEMALE","OTHER"};
		return Arrays.stream(genderList).anyMatch(valueToValidate.toUpperCase()::contains);
	}
}
