package com.technical.test.services.servicesImplement;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical.test.entities.User;
import com.technical.test.models.UserModel;
import com.technical.test.populators.UserPopulator;
import com.technical.test.repositories.UserRepository;
import com.technical.test.services.UserService;

@Service
public class UserServiceImplimentation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPopulator userMapper;

	@Override
	public UserModel getuser(Long id) {
		try {
			User user = userRepository.getById(id);
			return userMapper.toModel(user);
		} catch (EntityNotFoundException e) {
			return null;
		}
	}

	@Override
	public boolean adduser(UserModel userDto) {
		return userRepository.save(userMapper.toEntity(userDto)) != null;
	}

}
