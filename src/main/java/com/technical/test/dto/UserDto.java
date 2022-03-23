package com.technical.test.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.technical.test.controller.constraints.BirthDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends AbstractModel{
	
    @NotBlank(message = "Name is mandatory")
	private String name;
	
    @NotNull(message = "The date of birth is required.")
    @BirthDate(message = "The birth date must be greater or equal than 18")
    @Past(message = "The date of birth must be in the past.")
	private Date birthdate;
	
	private String countryOfResidence;
	
	private String phoneNumber;
	
	private String gender;

	public UserDto(String name, Date birthdate, String countryOfResidence, String phoneNumber, String gender) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.countryOfResidence = countryOfResidence;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public UserDto() {
		super();
	}
	

}
