package com.technical.test.service;

import com.technical.test.dto.UserDto;

public interface UserService {

	UserDto getuser(Long id);

	boolean adduser(UserDto userdto);

}
