package com.sk.service.impl;

import com.sk.dao.mybatis.UserDao;
import com.sk.entity.User;
import com.sk.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
	@Override
	public List<User> findAll() {
		UserDao mapper = ReportImpl.session.getMapper(UserDao.class);
		return mapper.userFindAll();

	}

	@Override
	public User findById(Integer id) {
		UserDao mapper = ReportImpl.session.getMapper(UserDao.class);
		return mapper.userFindById(id);
	}
}
