package com.sk.service.impl;

import com.sk.dao.mybatis.SessionDao;
import com.sk.entity.Session;
import com.sk.service.SessionService;

import java.util.List;

public class SessionServiceImpl implements SessionService {
	@Override
	public List<Session> findAll() {
		SessionDao mapper = ReportImpl.session.getMapper(SessionDao.class);
		return mapper.sessionFindAll();
	}

	@Override
	public Session findById(Integer id) {

		SessionDao mapper = ReportImpl.session.getMapper(SessionDao.class);
		return mapper.sessionFindById(id);

	}
}
