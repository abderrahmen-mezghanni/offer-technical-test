package com.technical.test.populators;

import org.springframework.stereotype.Component;

import com.technical.test.entities.User;
import com.technical.test.models.UserModel;

@Component
public class UserPopulator extends AbstractPopulator<User, UserModel> {

	@Override
	public UserModel toModel(User user) {
		UserModel userDto = new UserModel(user.getName(), user.getBirthdate(),
				user.getCountryOfResidence(), user.getPhoneNumber(), user.getGender());
		return userDto;
	}

	@Override
	public User toEntity(UserModel userDto) {
		User user = new User(userDto.getName(), userDto.getBirthdate(),
				userDto.getCountryOfResidence(), userDto.getPhoneNumber(), userDto.getGender());
		return user;
	}

	@Override
	public User updateToEntity(UserModel model, User entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
