package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.course;

public interface courseService {

    IPage<course> findAll(Page<course> page, Integer userId);

    public Integer add(course course);

    public Integer update(course course);
}
