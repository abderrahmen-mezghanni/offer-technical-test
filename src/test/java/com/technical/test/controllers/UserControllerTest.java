package com.technical.test.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.technical.test.exceptions.ResourceNotFoundException;
import com.technical.test.models.UserModel;
import com.technical.test.services.servicesImplement.UserServiceImplimentation;

import junit.framework.Assert;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserServiceImplimentation userServiceImplimentation;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testAddUser() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(userServiceImplimentation.addUser(any(UserModel.class))).thenReturn(1L);

		UserModel user = new UserModel("jean", new Date(1995, 03, 23), "french", "+33543953295", "MALE");
		ResponseEntity<Object> responseEntity = userController.addUser(user);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(responseEntity.getBody().equals("User added with Id : 1"));
	}

	@Test
	public void testGetUserNotFound() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(userServiceImplimentation.getUser(1L)).thenReturn(null);
		UserModel user;
		try {
			user = userController.getUser(1L);
			assertThat(user.equals(null));
		} catch (ResourceNotFoundException e) {
			exceptionRule.expect(ResourceNotFoundException.class);
			exceptionRule.expectMessage("No user found with the Id: 1");
		}
	}

	@Test
	public void testAddUserNotValidConstraintNumber() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		UserModel user = new UserModel("jean", new Date(2020, 03, 23), "spain", "+33543953295", "MAL");

		// Validate the object
		Set<ConstraintViolation<UserModel>> constraintViolations = validator.validate(user);

		// This is the line that will cause your unit test to fail if there are not any
		// violations
		Assert.assertEquals(4, constraintViolations.size());

	}
}
