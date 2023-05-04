package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.server.entity.project;

@Mapper
public interface projectMapper {
    @Select("select * from project")
    public IPage<project> findAll(Page page);

    @Select("select * from project where courseId = #{courseId}")
    public IPage<project> findByCourseId(Page page, Integer courseId);

    @Select("select * from project where projectId = #{projectId}")
    public project findByProjectId(Integer projectId);

    @Options(useGeneratedKeys = true, keyProperty = "projectId")
    @Insert("insert into project(projectName,courseId,courseName,studentNum,projectType)" +
            "values(#{projectName},#{courseId},#{courseName},#{studentNum},#{projectType})")
    public Integer add(project project);

    @Update("update project set projectName = #{projectName},courseId = #{courseId},courseName = #{courseName},studentNum = #{studentNum}," +
            "projectType = #{projectType} where projectId = #{projectId}")
    public Integer update(project project);

    @Delete("delete from project where projectId = #{projectId}")
    public Integer deleteById(Integer projectId);

    @Update("update project set studentNum = #{studentNum} " +
            "where projectId = #{projectId}")
    public Integer updateStudentNum(int projectId, int studentNum);
}
