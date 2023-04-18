package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.server.entity.file;

@Mapper
public interface fileMapper {
    @Select("select * from file where courseId = #{courseId}")
    public IPage<file> findByCourseId(Page page, Integer courseId);
    @Select("select * from file where fileId = #{fileId}")
    public file findByFileId(Integer fileId);

    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    @Insert("insert into file(filePath,outfileName,fileName,type,userId,userName,courseId,courseName,uploadTime)" +
            "values(#{filePath},#{outfileName},#{fileName},#{type},#{userId},#{userName},#{courseId},#{courseName},#{uploadTime})")
    public Integer add(file file);

    @Update("update file set filePath = #{filePath},fileName = #{fileName},type = #{type},userId = #{userId}," +
            "userName = #{userName},courseId = #{courseId},courseName = #{courseName} where fileId = #{fileId}")
    public Integer update(file file);
}
