package com.sk.service;

import com.sk.entity.UserGroup;

import java.util.List;

public interface UserGroupService {
    List<UserGroup> findAll();
    UserGroup findById();
}
