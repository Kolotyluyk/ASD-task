package com.sk.service.impl;


import com.sk.dao.myBatis.UserGroupDao;
import com.sk.entity.UserGroup;
import com.sk.service.UserGroupService;

import java.util.List;

public class UserGroupServiceImpl implements UserGroupService {
    @Override
    public List<UserGroup> findAll() {
        UserGroupDao mapper = ReportImpl.session.getMapper(UserGroupDao.class);
        return mapper.userGroupFindAll();
    }

    @Override
    public UserGroup findById() {
        return null;
    }
}
