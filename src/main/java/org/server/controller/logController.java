package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.ApiResult;
import org.server.entity.log;
import org.server.serviceImpl.logServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logController {
    private logServiceImpl logServiceimpl;

    @Autowired
    public logController(logServiceImpl logServiceimpl) {
        this.logServiceimpl = logServiceimpl;
    }

    @GetMapping("/log")
    public ApiResult findAll(@RequestParam("size") Integer size, @RequestParam("page") Integer page) {
        Page<log> logPage = new Page<>(page, size);
        IPage<log> logIPage = logServiceimpl.findAll(logPage);
        return ApiResultHandler.buildApiResult(200, "查询所有日志", logIPage);
    }
}
