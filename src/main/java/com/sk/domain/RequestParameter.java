package com.sk.domain;

public enum RequestParameter {

    FILTER("filter"),
    FORMAT("format"),
    EMAIL("email");
    public String getName() {
        return name;
    }

    private final String name;

    RequestParameter(String name) {
        this.name = name;
    }


}
