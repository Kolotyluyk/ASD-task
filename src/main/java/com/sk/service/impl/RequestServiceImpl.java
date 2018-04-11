package com.sk.service.impl;

import com.sk.dao.mybatis.RequestDao;
import com.sk.entity.Request;
import com.sk.service.RequestService;

import java.util.List;

public class RequestServiceImpl implements RequestService {
	@Override
	public List<Request> findAll() {
		RequestDao mapper = ReportImpl.session.getMapper(RequestDao.class);
		return mapper.requestFindAll();
	}

	@Override
	public Request findById(Integer id) {
		RequestDao mapper = ReportImpl.session.getMapper(RequestDao.class);
		return mapper.requestFindById(id);

	}
}
