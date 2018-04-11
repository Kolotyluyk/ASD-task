package com.sk.service;

import com.sk.entity.Country;
import com.sk.entity.Location;

import java.util.List;

public interface LocationService {

    List<Location> findAll();
    Location findById();
}
