package com.gds.springbootdemo.mapper;

import com.gds.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User findByName(@Param("username") String username);
    @Insert("INSERT INTO USERS(username, AGE) VALUES(#{username}, #{age})")
    int insert(@Param("username") String username, @Param("age") Integer age);

}
