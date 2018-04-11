package com.sk.dao.myBatis;

import com.sk.entity.UserGroup;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserGroupDao {

    @Select("select id, group_name as groupName from user_group WHERE id= #{id}")
    UserGroup userGroupFindById(Integer id);

    @Select("select id, group_name as groupName from user_group")
    List<UserGroup> userGroupFindAll();
}
