package com.sk.service.PoiService.impl;

import com.sk.dao.POI.POIDocDao;
import com.sk.dao.POI.POIXlsxDao;
import com.sk.entity.Request;
import com.sk.service.PoiService.POIService;

import java.util.List;

public class PoiServiceXLsxImpl implements POIService {
    @Override
    public String writeDocument(List<Request> request) {
        return new POIXlsxDao().writeToFile(request);
    }
}
