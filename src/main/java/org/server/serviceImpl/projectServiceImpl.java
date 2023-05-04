package org.server.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.project;
import org.server.service.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class projectServiceImpl implements projectService {
    @Autowired
    private org.server.mapper.projectMapper projectMapper;

    @Override
    public IPage<project> findAll(Page<project> page) {
        return projectMapper.findAll(page);
    }

    public IPage<project> findByCourseId(Page<project> page, Integer courseId) {
        return projectMapper.findByCourseId(page, courseId);
    }

    public project findByProjectId(Integer projectId) {
        return projectMapper.findByProjectId(projectId);
    }

    @Override
    public Integer add(project project) {
        return projectMapper.add(project);
    }

    @Override
    public Integer update(project project) {
        return projectMapper.update(project);
    }

    public Integer updateStudentNum(int projectId, int studentNum) {
        return projectMapper.updateStudentNum(projectId, studentNum);
    }

    ;
}
