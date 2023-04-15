package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.project;

public interface projectService {

    IPage<project> findAll(Page<project> page);

    public Integer add(project project);

    public Integer update(project project);
}
