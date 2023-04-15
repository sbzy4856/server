package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.ApiResult;
import org.server.entity.course;
import org.server.entity.project;
import org.server.entity.user;
import org.server.serviceImpl.projectServiceImpl;
import org.server.serviceImpl.courseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class projectController {
    private projectServiceImpl projectServiceimpl;
    private courseServiceImpl courseServiceimpl;

    @Autowired
    public projectController(projectServiceImpl projectServiceimpl,courseServiceImpl courseServiceimpl) {
        this.projectServiceimpl = projectServiceimpl;
        this.courseServiceimpl = courseServiceimpl;
    }

    @GetMapping("/project")
    public ApiResult findAll(@RequestParam("size") Integer size, @RequestParam("page") Integer page) {
        Page<project> projectPage = new Page<>(page, size);
        IPage<project> projectIPage = projectServiceimpl.findAll(projectPage);
        return ApiResultHandler.buildApiResult(200, "查询实验计划", projectIPage);
    }

    @PutMapping("/project/{courseId}")
    public ApiResult update(@RequestBody project project,@PathVariable("courseId") Integer courseId) {
        if (courseId == project.getCourseId()){
            return ApiResultHandler.success(projectServiceimpl.update(project));
        }else{
            course newCourse = courseServiceimpl.findByCourseId(project.getCourseId());
            int newProjectNum = newCourse.getProjectNum();
            newProjectNum++;
            course oldCourse = courseServiceimpl.findByCourseId(courseId);
            int oldProjectNum = oldCourse.getProjectNum();
            oldProjectNum--;
            courseServiceimpl.updateProjectNum(newCourse.getCourseId(),newProjectNum);
            courseServiceimpl.updateProjectNum(oldCourse.getCourseId(),oldProjectNum);
            return ApiResultHandler.success(projectServiceimpl.update(project));
        }
    }

    @PostMapping("/project")
    public ApiResult add(@RequestBody project project) {
        course course = courseServiceimpl.findByCourseId(project.getCourseId());
        int projectNum = course.getProjectNum();
        projectNum++;
        courseServiceimpl.updateProjectNum(course.getCourseId(),projectNum);
        return ApiResultHandler.success(projectServiceimpl.add(project));
    }
}
