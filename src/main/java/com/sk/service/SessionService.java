package com.sk.service;

import com.sk.entity.Session;

import java.util.List;

public interface SessionService {
    List<Session> findAll();
    Session findById(Integer id);
}
