package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.ApiResult;
import org.server.entity.course;
import org.server.entity.user;
import org.server.serviceImpl.courseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class courseController {
    private courseServiceImpl courseServiceimpl;

    @Autowired
    public courseController(courseServiceImpl courseServiceimpl) {
        this.courseServiceimpl = courseServiceimpl;
    }

    @GetMapping("/course")
    public ApiResult findByUserId(@RequestParam("size") Integer size, @RequestParam("page") Integer page, @RequestParam("userId") Integer userId) {
        Page<course> coursePage = new Page<>(page, size);
        IPage<course> courseIPage = courseServiceimpl.findByUserId(coursePage, userId);
        return ApiResultHandler.buildApiResult(200, "查询课程", courseIPage);
    }

    @GetMapping("/course/list")
    public ApiResult findAll(@RequestParam("size") Integer size, @RequestParam("page") Integer page) {
        Page<course> coursePage = new Page<>(page, size);
        IPage<course> courseIPage = courseServiceimpl.findAll(coursePage);
        return ApiResultHandler.buildApiResult(200, "查询课程", courseIPage);
    }

    @PutMapping("/course")
    public ApiResult update(@RequestBody course course) {
        return ApiResultHandler.success(courseServiceimpl.update(course));
    }

    @PostMapping("/course")
    public ApiResult add(@RequestBody course course, @RequestParam Integer userId, @RequestParam String userName) {
        course.setCourseState("开启");
        course.setProjectNum(0);
        course.setStudentNum(0);
        course.setTeacherId(userId);
        course.setTeacherName(userName);
        return ApiResultHandler.success(courseServiceimpl.add(course));
    }
}
