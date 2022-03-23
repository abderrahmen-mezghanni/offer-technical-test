package com.technical.test.controller;

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

import com.technical.test.dto.UserDto;
import com.technical.test.entity.User;
import com.technical.test.exceptions.ResourceNotFoundException;
import com.technical.test.service.UserService;


//allow the access from other servers
@CrossOrigin ("*") 
@RestController
@Validated
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserDto getuser(@PathVariable("id") Long id)  throws ResourceNotFoundException {
		UserDto userDto = userService.getuser(id);
	    if (userDto == null) {
	      throw new ResourceNotFoundException("No user found with the Id: " + id);
	    }
		return userDto;

	}
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity adduser(@Valid @RequestBody UserDto userDto) {
		if (userService.adduser(userDto)) {
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("user not added", HttpStatus.BAD_REQUEST);
		}

	}

}
