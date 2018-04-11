package com.sk.dao.myBatis;

import com.sk.entity.Session;
import com.sk.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface SessionDao {


    @Select("select * from session  WHERE id = #{id}")
    @Results(value = {
            @Result(property = "dateOpened", column = "date_opened"),
            @Result(property = "dateClosed", column = "date_closed"),
            @Result(property = "user", column = "user_id", one=@One(select = "com.sk.dao.myBatis.UserDao.userFindById"))

    })
    Session sessionFindById(Integer id);

    @Select("select * from session ")
    @Results(value = {
            @Result(property = "dateOpened", column = "date_opened"),
            @Result(property = "dateClosed", column = "date_closed"),
            @Result(property = "user", column = "user_id", one=@One(select = "com.sk.dao.myBatis.UserDao.userFindById"))})
    List<Session> sessionFindAll();
}
