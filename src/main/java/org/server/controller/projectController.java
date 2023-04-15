package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.ApiResult;
import org.server.entity.project;
import org.server.entity.user;
import org.server.serviceImpl.projectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class projectController {
    private projectServiceImpl projectServiceimpl;

    @Autowired
    public projectController(projectServiceImpl projectServiceimpl) {
        this.projectServiceimpl = projectServiceimpl;
    }

    @GetMapping("/project")
    public ApiResult findAll(@RequestParam("size") Integer size, @RequestParam("page") Integer page) {
        Page<project> projectPage = new Page<>(page, size);
        IPage<project> projectIPage = projectServiceimpl.findAll(projectPage);
        return ApiResultHandler.buildApiResult(200, "查询实验计划", projectIPage);
    }

    @PutMapping("/project")
    public ApiResult update(@RequestBody project project) {
        return ApiResultHandler.success(projectServiceimpl.update(project));
    }

    @PostMapping("/project")
    public ApiResult add(@RequestBody project project) {
        return ApiResultHandler.success(projectServiceimpl.add(project));
    }
}
