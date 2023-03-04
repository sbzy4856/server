package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.server.entity.notice;

import java.util.List;

@Mapper
public interface noticeMapper {
    @Select("select * from notice")
    public IPage<notice> findAll(Page page);

    @Select("select * from notice where noticeTitle = #{title}")
    public IPage<notice> selectByTitle(Page page, String title);

    @Select("select * from notice where noticeState = #{state}")
    public IPage<notice> selectByState(Page page, String state);

    @Select("select * from notice where noticeState = #{state} and noticeTitle = #{title}")
    public IPage<notice> selectByTitleAndState(Page page, String title, String state);

    @Delete("delete from notice where noticeId = #{noticeId}")
    public Integer deleteById(Integer noticeId);

    @Update("update notice set noticeContent = #{noticeContent},updateTime = #{updateTime}," +
            "handler = #{handler},noticeTitle = #{noticeTitle}")
    public Integer update(notice notice);

    @Update("update notice set noticeState = #{noticeState}")
    public Integer updateState(String noticeState);

    @Options(useGeneratedKeys = true, keyProperty = "noticeId")
    @Insert("insert into notice(noticeContent,updateTime,handler,noticeState,noticeTitle) " +
            "values(#{noticeContent},#{updateTime},#{handler},#{noticeState},#{noticeTitle}")
    public Integer add(notice notice);
}
