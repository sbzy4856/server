package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.user;
import org.server.entity.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper {

    @Select("select * from user")
    public IPage<user> findAll(Page page);

    @Select("select * from user where userAccount = #{account}")
    public IPage<user> selectByAccount(Page page, String account);

    @Select("select * from user where userType = #{type}")
    public IPage<user> selectByType(Page page, String type);

    @Select("select * from user where userAccount = #{account} and userType = #{type}")
    public IPage<user> selectByAccountAndType(Page page, String account, String type);

    @Select("select * from user where userAccount = #{account}")
    public user findByAccount(String account);

    @Delete("delete from user where userId = #{userId}")
    public Integer deleteById(Integer userId);

    @Update("update user set userName = #{userName},userType = #{userType},userState = #{userState}," +
            "password = #{password},userAccount = #{userAccount} where userId = #{userId}")
    public Integer update(user user);

    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @Insert("insert into user(userAccount,userName,password,userType,userState) " +
            "values(#{userAccount},#{userName},#{password},#{userType},#{userState})")
    public Integer add(user user);

    @Select("select * from user where userAccount = #{userAccount} and password = #{password}")
    public user userLogin(String userAccount, String password);

}
