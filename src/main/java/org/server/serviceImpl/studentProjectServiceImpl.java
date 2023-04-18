package org.server.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.studentProject;
import org.server.service.studentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentProjectServiceImpl implements studentProjectService {
    @Autowired
    private org.server.mapper.studentProjectMapper studentProjectMapper;

    @Override
    public IPage<studentProject> findByCourseId(Page<studentProject> page, Integer courseId) {
        return studentProjectMapper.findByCourseId(page, courseId);
    }

    @Override
    public Integer add(studentProject studentProject) {
        return studentProjectMapper.add(studentProject);
    }

    @Override
    public Integer update(studentProject studentProject) {
        return studentProjectMapper.update(studentProject);
    }

}
