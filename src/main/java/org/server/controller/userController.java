package org.server.controller;

import org.server.api.ApiResultHandler;
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
    public ApiResult findAll() {
        System.out.println("查询全部");
        return ApiResultHandler.success(userServiceimpl.findAll());
    }

    @GetMapping("/user/{userId}")
    public ApiResult findById(@PathVariable("userId") Integer userId) {
        System.out.println("根据ID查找");
        return ApiResultHandler.success(userServiceimpl.findById(userId));
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