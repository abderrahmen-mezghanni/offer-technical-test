package com.technical.test.controller.constraints;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BirthDateValidator implements ConstraintValidator<BirthDate, Date> {
	@Override
	public boolean isValid(final Date birthdateToValidate, final ConstraintValidatorContext context) {
		if (birthdateToValidate == null) {
			return false;
		}
		Calendar dateInCalendar = Calendar.getInstance();
		dateInCalendar.setTime(birthdateToValidate);

		return Calendar.getInstance().get(Calendar.YEAR) - dateInCalendar.get(Calendar.YEAR) >= 18;
	}
}
