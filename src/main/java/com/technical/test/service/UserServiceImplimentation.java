package com.technical.test.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical.test.dto.UserDto;
import com.technical.test.entity.User;
import com.technical.test.mapper.UserMapper;
import com.technical.test.repository.UserRepository;

@Service
public class UserServiceImplimentation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto getuser(Long id) {
		try {
			User user = userRepository.getById(id);
			return userMapper.toModel(user);
		} catch (EntityNotFoundException e) {
			return null;
		}
	}

	@Override
	public boolean adduser(UserDto userDto) {
		return userRepository.save(userMapper.toEntity(userDto)) != null;
	}

}
