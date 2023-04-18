package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.ApiResult;
import org.server.entity.course;
import org.server.entity.studentProject;
import org.server.entity.user;
import org.server.serviceImpl.studentProjectServiceImpl;
import org.server.serviceImpl.courseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class studentProjectController {
    private studentProjectServiceImpl studentProjectServiceimpl;
    private courseServiceImpl courseServiceimpl;

    @Autowired
    public studentProjectController(studentProjectServiceImpl studentProjectServiceimpl, courseServiceImpl courseServiceimpl) {
        this.studentProjectServiceimpl = studentProjectServiceimpl;
        this.courseServiceimpl = courseServiceimpl;
    }

    @GetMapping("/studentProject")
    public ApiResult findByCourseId(@RequestParam("size") Integer size, @RequestParam("page") Integer page, @RequestParam("courseId") Integer courseId) {
        Page<studentProject> studentProjectPage = new Page<>(page, size);
        IPage<studentProject> studentProjectIPage = studentProjectServiceimpl.findByCourseId(studentProjectPage, courseId);
        return ApiResultHandler.buildApiResult(200, "查询实验计划", studentProjectIPage);
    }

    @PutMapping("/studentProject")
    public ApiResult update(@RequestBody studentProject studentProject) {
        return ApiResultHandler.success(studentProjectServiceimpl.update(studentProject));
    }

    @PostMapping("/studentProject")
    public ApiResult add(@RequestBody studentProject studentProject) {
        return ApiResultHandler.success(studentProjectServiceimpl.add(studentProject));
    }
}
