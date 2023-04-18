package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.course;
import org.server.entity.studentProject;

public interface studentProjectService {

    IPage<studentProject> findByCourseId(Page<studentProject> page, Integer courseId);

    public Integer add(studentProject studentProject);

    public Integer update(studentProject studentProject);
}
