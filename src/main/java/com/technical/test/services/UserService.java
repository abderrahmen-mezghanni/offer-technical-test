package com.technical.test.services;

import com.technical.test.models.UserModel;

public interface UserService {

	UserModel getuser(Long id);

	Long adduser(UserModel userdto);

}
