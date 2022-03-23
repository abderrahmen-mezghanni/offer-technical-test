package com.technical.test.controller.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<Country, String> {

	@Override
	public boolean isValid(final String valueToValidate, ConstraintValidatorContext context) {
		if (valueToValidate.toLowerCase().contains("french")) {
			return true;
		}
		return false;
	}
}
