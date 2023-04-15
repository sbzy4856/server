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
        return projectMapper.findByUserId(page);
    }

    @Override
    public Integer add(project project) {
        return projectMapper.add(project);
    }

    @Override
    public Integer update(project project) {
        return projectMapper.update(project);
    }
}
