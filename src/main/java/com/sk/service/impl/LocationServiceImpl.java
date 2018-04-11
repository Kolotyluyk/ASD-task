package com.sk.service.impl;


import com.sk.dao.myBatis.LocationDao;
import com.sk.entity.Location;
import com.sk.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {
    @Override
    public List<Location> findAll() {
        LocationDao mapper = ReportImpl.session.getMapper(LocationDao.class);
        return mapper.locationFindAll();
    }

    @Override
    public Location findById(Integer id) {
        LocationDao mapper = ReportImpl.session.getMapper(LocationDao.class);
        return mapper.locationFindById(id);

    }
}
