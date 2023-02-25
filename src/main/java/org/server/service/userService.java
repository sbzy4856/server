package org.server.service;

import org.server.entity.user;

import java.util.List;

public interface userService {

    public List<user> findAll();

    public user findById(Integer userId);

    public Integer deleteById(Integer userId);

    public Integer update(user user);

    public Integer add(user user);

    public user userLogin(Integer userAccount, String password);


}
