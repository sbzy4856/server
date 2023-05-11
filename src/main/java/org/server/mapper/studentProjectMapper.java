package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.server.entity.studentProject;

@Mapper
public interface studentProjectMapper {
    @Select("select * from student_project where projectId = #{projectId}")
    public IPage<studentProject> findByProjectId(Page page, Integer projectId);

    @Select("select * from student_project where studentId = #{studentId}")
    public IPage<studentProject> findByStudentId(Page page, Integer studentId);

    @Select("select * from student_project where projectId = #{projectId} and studentId = #{studentId}")
    public studentProject findByProjectIdAndStudentId(Integer projectId, Integer studentId);

    @Insert("insert into student_project(studentId,studentName,courseId,courseName,projectId,projectName)" +
            "values(#{studentId},#{studentName},#{courseId},#{courseName},#{projectId},#{projectName})")
    public Integer add(studentProject studentProject);

    @Update("update student_project set score = #{score} " +
            "where projectId = #{projectId} and studentId = #{studentId}")
    public Integer update(studentProject studentProject);

    @Delete("delete from studentProject where studentProjectId = #{studentProjectId}")
    public Integer deleteById(Integer studentProjectId);
}
