package com.sk.dao.myBatis;

import com.sk.entity.Country;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CountryDao {
    @Select("select * from country  WHERE id = #{id}")
    @Results(value = {
            @Result(property = "countryName", column = "country_name"),
              })
    Country countryFindById(Integer id);

    @Select("select * from country ")
    @Results(value = {
            @Result(property = "countryName", column = "country_name"),
    })
    List<Country> countryFindAll();

}
