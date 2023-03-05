package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.user;
import org.server.entity.user;
import org.server.entity.ApiResult;
import org.server.serviceImpl.userServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {

    private userServiceImpl userServiceimpl;

    @Autowired
    public userController(userServiceImpl userServiceimpl) {
        this.userServiceimpl = userServiceimpl;
    }

    @GetMapping("/user")
    public ApiResult findAll(@RequestParam("size") Integer size, @RequestParam("page") Integer page,
                             @RequestParam("account") String account, @RequestParam("type") String type) {
        Page<user> userPage = new Page<>(page, size);
        if (account == "" && type == "") {
            IPage<user> userIPage = userServiceimpl.findAll(userPage);
            return ApiResultHandler.buildApiResult(200, "查询所有公告", userIPage);
        } else if ("".equals(account) && !"".equals(type)) {
            IPage<user> userIPage = userServiceimpl.selectByType(userPage, type);
            return ApiResultHandler.buildApiResult(200, "通过状态查找", userIPage);
        } else if (!"".equals(account) && "".equals(type)) {
            IPage<user> userIPage = userServiceimpl.selectByAccount(userPage, account);
            return ApiResultHandler.buildApiResult(200, "通过标题查找", userIPage);
        } else {
            IPage<user> userIPage = userServiceimpl.selectByAccountAndType(userPage, account, type);
            return ApiResultHandler.buildApiResult(200, "通过标题和状态查找", userIPage);
        }

    }

    @DeleteMapping("/user/{userId}")
    public ApiResult deleteById(@PathVariable("userId") Integer userId) {
        userServiceimpl.deleteById(userId);
        return ApiResultHandler.success();
    }

    @PutMapping("/user/{userId}")
    public ApiResult update(@PathVariable("userId") Integer userId, user user) {
        return ApiResultHandler.success(userServiceimpl.update(userId, user));
    }

    @PostMapping("/user")
    public ApiResult add(@RequestBody user user) {
        user user1 = userServiceimpl.findByAccount(user.getUserAccount());
        if (user1 != null) {
            return ApiResultHandler.buildApiResult(400, "已存在账号，请重新输入账号！", null);
        }
        if ("学生".equals(user.getUserType())) {
            user.setUserName("学生");
            user.setUserState("未激活");
        } else if ("助教".equals(user.getUserType())) {
            user.setUserName("助教");
            user.setUserState("已激活");
        } else {
            user.setUserName("教师");
            user.setUserState("已激活");
        }
        return ApiResultHandler.success(userServiceimpl.add(user));
    }

    @PostMapping("/login")
    public ApiResult login(@RequestBody user user) {
        String userAccount = user.getUserAccount();
        String password = user.getPassword();
        user userRes = userServiceimpl.userLogin(userAccount, password);
        if (userRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", userRes);
        }
        return ApiResultHandler.buildApiResult(400, "账号或密码错误", null);
    }
}