package com.sk.service;

import com.sk.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
}
