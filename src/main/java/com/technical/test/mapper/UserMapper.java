package com.technical.test.mapper;

import org.springframework.stereotype.Component;

import com.technical.test.dto.UserDto;
import com.technical.test.entity.User;
import com.technical.test.enumeration.Gender;

@Component
public class UserMapper extends AbstractPopulator<User, UserDto> {

	@Override
	public UserDto toModel(User user) {
		UserDto userDto = new UserDto(user.getName(), user.getBirthdate(),
				user.getCountryOfResidence(), user.getPhoneNumber(), user.getGender().label);
		return userDto;
	}

	@Override
	public User toEntity(UserDto userDto) {
		Gender gender = Gender.valueOf(userDto.getGender());
		User user = new User(userDto.getName(), userDto.getBirthdate(),
				userDto.getCountryOfResidence(), userDto.getPhoneNumber(), gender);
		return user;
	}

	@Override
	public User updateToEntity(UserDto model, User entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
