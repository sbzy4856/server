package org.server.serviceImpl;

import org.server.entity.user;
import org.server.mapper.userMapper;
import org.server.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;

    @Override
    public List<user> findAll() {
        return userMapper.findAll();
    }

    @Override
    public user findById(Integer userId) {
        return userMapper.findById(userId);
    }

    @Override
    public Integer deleteById(Integer userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public Integer update(user user) {
        return userMapper.update(user);
    }

    @Override
    public Integer add(user user) {
        return 0;
    }

    @Override
    public user userLogin(String userAccount, String password) {
        return userMapper.userLogin(userAccount, password);
    }
}