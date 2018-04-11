package com.sk.entity;

import java.util.List;

public class User {
    Integer id;
    Integer userName;
    UserGroup userGroup;
    Location location;



    public User() {
    }

    public User(Integer id, Integer userName, Location location, UserGroup userGroupId) {
        this.id = id;
        this.userName = userName;
        this.location = location;
        this.userGroup = userGroupId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserName() {
        return userName;
    }

    public void setUserName(Integer userName) {
        this.userName = userName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public UserGroup getUserGroupId() {
        return userGroup;
    }

    public void setUserGroupId(UserGroup userGroupId) {
        this.userGroup = userGroupId;
    }

}
