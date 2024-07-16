package com.testjunit.api.services;

import com.testjunit.api.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();

}
