package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.course;
import org.server.entity.studentProject;

public interface studentProjectService {

    IPage<studentProject> findByProjectId(Page<studentProject> page, Integer projectId);

    IPage<studentProject> findByStudentId(Page<studentProject> page, Integer studentId);

    public studentProject findByProjectIdAndStudentId(Integer projectId, Integer studentId);

    public Integer add(studentProject studentProject);

    public Integer update(studentProject studentProject);
}
