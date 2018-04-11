package com.sk.service.impl;


import com.sk.dao.myBatis.CountryDao;
import com.sk.entity.Country;
import com.sk.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    @Override
    public List<Country> findAll() {
        CountryDao mapper = ReportImpl.session.getMapper(CountryDao.class);
        return mapper.countryFindAll();
    }

    @Override
    public Country findById(Integer id) {
        CountryDao mapper = ReportImpl.session.getMapper(CountryDao.class);
        return mapper.countryFindById(id);
    }
}
