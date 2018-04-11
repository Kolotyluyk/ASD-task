package com.sk.service;

import com.sk.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country findById(Integer id);

}
