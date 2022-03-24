package com.technical.test.services;

import com.technical.test.models.UserModel;

public interface UserService {

	UserModel getUser(Long id);

	Long addUser(UserModel userdto);

}
