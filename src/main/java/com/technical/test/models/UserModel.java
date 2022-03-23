package com.technical.test.models;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.technical.test.controller.constraints.BirthDate;
import com.technical.test.controller.constraints.Country;
import com.technical.test.controller.constraints.Gender;
import com.technical.test.controller.constraints.Phone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel extends AbstractModel{
	
    @NotBlank(message = "Name is mandatory")
	private String name;
	
    @NotNull(message = "The date of birth is required.")
    @BirthDate(message = "You must be an adult : age greater must be 18")
    @Past(message = "The date of birth must be in the past.")
	private Date birthdate;
	
    @NotNull(message = "Country of residence is required.")
    @Country(message = "You must be French residents  to register" )
	private String countryOfResidence;
	
	@Phone(message = "Phone must have this form : +33 X XX XX XX XX or 0X XX XX XX XX")
	private String phoneNumber;
	
	@Gender(message = "Gender must be MALE, FEMALE or OTHER")
	private String gender;

	public UserModel(String name, Date birthdate, String countryOfResidence, String phoneNumber, String gender) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.countryOfResidence = countryOfResidence;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public UserModel() {
		super();
	}
	

}
