package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.course;
import org.server.entity.project;

public interface projectService {

    IPage<project> findAll(Page<project> page);

    IPage<project> findByCourseId(Page<project> page, Integer courseId);

    public project findByProjectId(Integer projectId);

    public Integer add(project project);

    public Integer update(project project);

    public Integer updateStudentNum(int projectId, int studentNum);
}
