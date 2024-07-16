package com.testjunit.api.services;

import com.testjunit.api.domain.User;

public interface UserService {
    User findById(Integer id);

}
