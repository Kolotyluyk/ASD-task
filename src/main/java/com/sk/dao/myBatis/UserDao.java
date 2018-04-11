package com.sk.dao.myBatis;

import com.sk.entity.Session;
import com.sk.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user  WHERE id = #{id}")
    @Results(value = {
            @Result(property = "userName", column = "user_name"),
            @Result(property = "dateClosed", column = "date_closed"),
            @Result(property = "location", column = "location_id", one=@One(select = "com.sk.dao.myBatis.LocationDao.locationFindById")),
            @Result(property = "userGroup", column = "user_group_id", one=@One(select = "com.sk.dao.myBatis.UserGroupDao.userGroupFindById"))
})
    User userFindById(Integer id);


    @Select("select * from user")
    @Results(value = {
            @Result(property = "userName", column = "user_name"),
            @Result(property = "dateClosed", column = "date_closed"),
            @Result(property = "location", column = "location_id", one=@One(select = "com.sk.dao.myBatis.LocationDao.locationFindById")),
            @Result(property = "userGroup", column = "user_group_id", one=@One(select = "com.sk.dao.myBatis.UserGroupDao.userGroupFindById"))
    })  List<User> userFindAll();


}
