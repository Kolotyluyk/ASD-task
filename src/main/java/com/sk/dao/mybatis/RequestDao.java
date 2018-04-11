package com.sk.dao.mybatis;

import com.sk.entity.Request;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RequestDao {
	@Select("select * from request WHERE id = #{id}")
	@Results(value = { @Result(property = "session", column = "session_id", one = @One(select = "com.sk.dao.myBatis.SessionDao.sessionFindById")) })
	Request requestFindById(Integer id);

	@Select("select * from request")
	@Results(value = { @Result(property = "session", column = "session_id", one = @One(select = "com.sk.dao.myBatis.SessionDao.sessionFindById")) })
	List<Request> requestFindAll();

}
