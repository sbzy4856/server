package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.user;
import org.server.entity.user;

import java.util.List;

public interface userService {

    IPage<user> findAll(Page<user> page);

    IPage<user> selectByAccount(Page<user> page, String account);

    IPage<user> selectByType(Page<user> page, String type);

    IPage<user> selectByAccountAndType(Page<user> page, String account, String type);

    public user findByAccount(String account);

    public Integer deleteById(Integer userId);

    public Integer update(Integer userId, user user);

    public Integer add(user user);

    public user userLogin(String userAccount, String password);


}
