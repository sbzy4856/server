package org.server.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public IPage<user> findAll(Page<user> page) {
        return userMapper.findAll(page);
    }

    public IPage<user> selectByAccount(Page<user> page, String account) {
        return userMapper.selectByAccount(page, account);
    }

    public IPage<user> selectByType(Page<user> page, String type) {
        return userMapper.selectByType(page, type);
    }

    public IPage<user> selectByAccountAndType(Page<user> page, String account, String type) {
        return userMapper.selectByAccountAndType(page, account, type);
    }

    @Override
    public user findByAccount(String account) {
        return userMapper.findByAccount(account);
    }

    @Override
    public Integer deleteById(Integer userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public Integer update(Integer userId, user user) {
        return userMapper.update(userId, user.getUserName(), user.getPassword());
    }

    @Override
    public Integer add(user user) {
        return userMapper.add(user);
    }

    @Override
    public user userLogin(String userAccount, String password) {
        return userMapper.userLogin(userAccount, password);
    }
}