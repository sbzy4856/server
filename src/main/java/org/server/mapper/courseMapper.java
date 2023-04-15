package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.server.entity.course;

@Mapper
public interface courseMapper {
    @Select("select * from course where teacherId = #{userId}")
    public IPage<course> findByUserId(Page page, Integer userId);

    @Options(useGeneratedKeys = true, keyProperty = "courseId")
    @Insert("insert into course(projectNum,courseName,studentNum,teacherId,teacherName,courseState)" +
            "values(#{projectNum},#{courseName},#{studentNum},#{teacherId},#{teacherName},#{courseState})")
    public Integer add(course course);

    @Update("update course set projectNum = #{projectNum},courseName = #{courseName},studentNum = #{studentNum},teacherId = #{teacherId}," +
            "teacherName = #{teacherName},courseState = #{courseState} where courseId = #{courseId}")
    public Integer update(course course);

    @Update("update course set projectNum = #{projectNum} " +
            "where courseId = #{courseId}")
    public Integer updateProjectNum(int courseId, String projectNum);

    @Update("update course set studentNum = #{studentNum} " +
            "where courseId = #{courseId}")
    public Integer updateStudentNum(int courseId, String studentNum);
}
