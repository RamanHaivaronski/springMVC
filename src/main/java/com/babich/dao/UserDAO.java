package com.babich.dao;

import com.babich.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDAO {


    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Delete("delete from users where user_id=#{id}")
    void delete(int id);

    @Insert("insert into users(name, surname) values(#{name},#{surname})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "user_id", before = false, resultType=Integer.class)
    void addUser(User user);
}
