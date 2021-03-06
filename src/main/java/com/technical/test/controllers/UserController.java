package com.technical.test.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technical.test.exceptions.ResourceNotFoundException;
import com.technical.test.models.UserModel;
import com.technical.test.services.UserService;

//allow the access from other servers
@CrossOrigin("*")
@RestController
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserModel getUser(@PathVariable("id") Long id) throws ResourceNotFoundException {
		UserModel userDto = userService.getUser(id);
		if (userDto == null) {
			throw new ResourceNotFoundException("No user found with the Id: " + id);
		}
		return userDto;

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addUser(@Valid @RequestBody UserModel userDto) {
		Long idCreatedUser = userService.addUser(userDto);
		if (idCreatedUser != null) {
			return new ResponseEntity<>("User added with Id : " + idCreatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User not added", HttpStatus.BAD_REQUEST);
		}

	}

}
