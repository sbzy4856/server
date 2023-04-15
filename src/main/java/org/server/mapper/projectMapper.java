package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.server.entity.project;

@Mapper
public interface projectMapper {
    @Select("select * from project")
    public IPage<project> findByUserId(Page page);

    @Options(useGeneratedKeys = true, keyProperty = "projectId")
    @Insert("insert into project(projectName,courseId,courseName,studentId,projectType)" +
            "values(#{projectName},#{courseId},#{courseName},#{studentId},#{projectType}")
    public Integer add(project project);

    @Update("update project set projectName = #{projectName},courseId = #{courseId},courseName = #{courseName},studentId = #{studentId}," +
            "projectType = #{projectType} where projectId = #{projectId}")
    public Integer update(project project);

    @Delete("delete from project where projectId = #{projectId}")
    public Integer deleteById(Integer projectId);
}
