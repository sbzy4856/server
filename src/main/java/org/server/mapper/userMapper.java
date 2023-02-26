package org.server.mapper;

import org.server.entity.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper {

    @Select("select * from user")
    public List<user> findAll();

    @Select("select * from user where userId = #{userId}")
    public user findById(Integer userId);

    @Delete("delete from user where userId = #{userId}")
    public Integer deleteById(Integer userId);

    @Update("update user set userName = #{userName}," +
            "password = #{password} where userId = #{userId}")
    public Integer update(user user);

    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @Insert("insert into user(userAccount,userName,password,userType) " +
            "values(#{userAccount},#{userName},#{password},#{userType}")
    public Integer add(user user);

    @Select("select * from user where userAccount = #{userAccount} and password = #{password}")
    public user userLogin(String userAccount, String password);

}
