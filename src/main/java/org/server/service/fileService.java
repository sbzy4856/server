package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.course;
import org.server.entity.file;

public interface fileService {

    IPage<file> findAll(Page<file> page, Integer courseId);

    public file findByFileId(Integer fileId);

    public Integer add(file file);

    public Integer update(file file);
}
