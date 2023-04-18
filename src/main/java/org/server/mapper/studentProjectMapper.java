package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.server.entity.studentProject;

@Mapper
public interface studentProjectMapper {
    @Select("select * from student_project where courseId = #{courseId}")
    public IPage<studentProject> findByCourseId(Page page, Integer courseId);

    @Insert("insert into student_project(studentId,studentName,courseId,courseName,projectId,projectName)" +
            "values(#{studentId},#{studentName},#{courseId},#{courseName},#{projectId},#{projectName})")
    public Integer add(studentProject studentProject);

    @Update("update student_project set studentName = #{studentName},courseId = #{courseId},courseName = #{courseName}," +
            "score = #{score} where studentId = #{studentId}")
    public Integer update(studentProject studentProject);

    @Delete("delete from studentProject where studentProjectId = #{studentProjectId}")
    public Integer deleteById(Integer studentProjectId);
}