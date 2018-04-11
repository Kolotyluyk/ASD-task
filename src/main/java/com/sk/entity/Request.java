package com.sk.entity;

import java.util.List;

public class Request {

    Integer id;
    String url;
    String method;
    String params;
    Session session;

    public Request(Integer id, String url, String method, String params, Session session) {
        this.id = id;
        this.url = url;
        this.method = method;
        this.params = params;
        this.session = session;
    }

    public Request() {

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
