package com.technical.test.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "BIRTH_DATE", nullable = false)
	private Date birthdate;
	
	@Column(name = "COUNTRY_OF_RESIDENCE", nullable = false)
	private String countryOfResidence;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "GENDER")
	private String gender;


	public User(String name, Date birthdate, String countryOfResidence, String phoneNumber, String gender) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.countryOfResidence = countryOfResidence;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}


	public User() {
		super();
	}
	

}
