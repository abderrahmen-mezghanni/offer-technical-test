package com.technical.test.controller.constraints;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, String> {

	@Override
	public boolean isValid(final String Gender, ConstraintValidatorContext context) {
		if (Gender == null || Gender.length() == 0) {
			return true;
		}
		String[] genderList = { "MALE", "FEMALE", "OTHER" };
		return Arrays.stream(genderList).anyMatch(Gender.toUpperCase()::contains);
	}
}
