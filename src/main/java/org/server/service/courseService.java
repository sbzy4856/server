package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.course;

public interface courseService {

    IPage<course> findByUserId(Page<course> page, Integer userId);

    IPage<course> findAll(Page page);

    public course findByCourseId(Integer courseId);

    public Integer add(course course);

    public Integer update(course course);

    public Integer updateProjectNum(int courseId, int projectNum);

    public Integer updateStudentNum(int courseId, int studentNum);
}
