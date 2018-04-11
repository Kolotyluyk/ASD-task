package com.sk.service;

import com.sk.entity.Request;

import java.util.List;

public interface RequestService {
    List<Request> findAll();
    Request findById();
}
