package com.sk.service.poi.impl;

import com.sk.dao.poi.PoiDocDao;
import com.sk.entity.Request;
import com.sk.service.poi.PoiService;

import java.util.List;

public class PoiServiceDocImpl implements PoiService {
	@Override
	public String writeDocument(List<Request> request) {
		return new PoiDocDao().writeToFile(request);
	}
}
