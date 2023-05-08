package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.*;
import org.server.serviceImpl.projectServiceImpl;
import org.server.serviceImpl.studentProjectServiceImpl;
import org.server.serviceImpl.courseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class studentProjectController {
    private studentProjectServiceImpl studentProjectServiceimpl;
    private courseServiceImpl courseServiceimpl;
    private projectServiceImpl projectServiceimpl;

    @Autowired
    public studentProjectController(studentProjectServiceImpl studentProjectServiceimpl, courseServiceImpl courseServiceimpl, projectServiceImpl projectServiceimpl) {
        this.studentProjectServiceimpl = studentProjectServiceimpl;
        this.courseServiceimpl = courseServiceimpl;
        this.projectServiceimpl = projectServiceimpl;
    }

    @GetMapping("/studentProject")
    public ApiResult findByProjectId(@RequestParam("size") Integer size, @RequestParam("page") Integer page, @RequestParam("projectId") Integer projectId) {
        Page<studentProject> studentProjectPage = new Page<>(page, size);
        IPage<studentProject> studentProjectIPage = studentProjectServiceimpl.findByProjectId(studentProjectPage, projectId);
        return ApiResultHandler.buildApiResult(200, "查询实验计划", studentProjectIPage);
    }

    @GetMapping("/studentProject/studentId")
    public ApiResult findByStudentId(@RequestParam("size") Integer size, @RequestParam("page") Integer page, @RequestParam("studentId") Integer studentId) {
        Page<studentProject> studentProjectPage = new Page<>(page, size);
        IPage<studentProject> studentProjectIPage = studentProjectServiceimpl.findByStudentId(studentProjectPage, studentId);
        return ApiResultHandler.buildApiResult(200, "查询实验计划", studentProjectIPage);
    }

    @PutMapping("/studentProject")
    public ApiResult update(@RequestBody studentProject studentProject) {
        return ApiResultHandler.success(studentProjectServiceimpl.update(studentProject));
    }

    @PostMapping("/studentProject")
    public ApiResult add(@RequestBody studentProject studentProject) {
        studentProject sp = studentProjectServiceimpl.findByProjectIdAndStudentId(studentProject.getProjectId(), studentProject.getStudentId());
        if (null != sp) {
            return ApiResultHandler.buildApiResult(400, "您已参加过此课程不可重复参加！", null);
        } else {
            course course = courseServiceimpl.findByCourseId(studentProject.getCourseId());
            int studentNum = course.getStudentNum();
            studentNum++;
            courseServiceimpl.updateStudentNum(course.getCourseId(), studentNum);
            project project = projectServiceimpl.findByProjectId(studentProject.getProjectId());
            int proStudentNum = project.getStudentNum();
            proStudentNum++;
            projectServiceimpl.updateStudentNum(project.getProjectId(), proStudentNum);
            return ApiResultHandler.success(studentProjectServiceimpl.add(studentProject));
        }
    }
}
