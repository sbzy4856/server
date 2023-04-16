package org.server.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.file;
import org.server.service.fileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class fileServiceImpl implements fileService {
    @Autowired
    private org.server.mapper.fileMapper fileMapper;

    @Override
    public IPage<file> findAll(Page<file> page, Integer courseId) {
        return fileMapper.findByCourseId(page, courseId);
    }

    public file findByFileId(Integer fileId) {
        return fileMapper.findByFileId(fileId);
    }

    @Override
    public Integer add(file file) {
        return fileMapper.add(file);
    }

    @Override
    public Integer update(file file) {
        return fileMapper.update(file);
    }

}
