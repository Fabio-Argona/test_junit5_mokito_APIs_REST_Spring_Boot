package com.testjunit.api.services;

import com.testjunit.api.domain.User;
import com.testjunit.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);

}
