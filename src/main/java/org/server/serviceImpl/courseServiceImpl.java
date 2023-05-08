package org.server.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.course;
import org.server.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class courseServiceImpl implements courseService {
    @Autowired
    private org.server.mapper.courseMapper courseMapper;

    @Override
    public IPage<course> findByUserId(Page<course> page, Integer userId) {
        return courseMapper.findByUserId(page, userId);
    }

    public IPage<course> findAll(Page page) {
        return courseMapper.findAll(page);
    }

    public course findByCourseId(Integer courseId) {
        return courseMapper.findByCourseId(courseId);
    }

    @Override
    public Integer add(course course) {
        return courseMapper.add(course);
    }

    @Override
    public Integer update(course course) {
        return courseMapper.update(course);
    }

    public Integer updateProjectNum(int courseId, int projectNum) {
        return courseMapper.updateProjectNum(courseId, projectNum);
    }

    public Integer updateStudentNum(int courseId, int studentNum) {
        return courseMapper.updateStudentNum(courseId, studentNum);
    }
}
