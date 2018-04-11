package com.sk.dao.mybatis;

import com.sk.entity.Location;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LocationDao {
	@Select("select * from location WHERE id = #{id}")
	@Results(value = { @Result(property = "country", column = "country_id", one = @One(select = "com.sk.dao.myBatis.CountryDao.countryFindById")),
			@Result(property = "locationName", column = "location_name") })
	Location locationFindById(Integer id);

	@Select("select * from location ")
	@Results(value = { @Result(property = "locationName", column = "location_name"),
			@Result(property = "country", column = "country_id", one = @One(select = "com.sk.dao.myBatis.CountryDao.countryFindById")) })
	List<Location> locationFindAll();
}
