package com.sk.service.poi.impl;

import com.sk.dao.poi.PoiXlsxDao;
import com.sk.entity.Request;
import com.sk.service.poi.PoiService;

import java.util.List;

public class PoiServiceXlsxImpl implements PoiService {
	@Override
	public String writeDocument(List<Request> request) {
		return new PoiXlsxDao().writeToFile(request);
	}
}
