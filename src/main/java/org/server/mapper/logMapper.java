package org.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.server.entity.log;

@Mapper
public interface logMapper {
    @Select("select * from log")
    public IPage<log> findAll(Page page);

    @Options(useGeneratedKeys = true, keyProperty = "logId")
    @Insert("insert into log(logAccount,logName,logTime)" +
            "values(#{logAccount},#{logName},#{logTime})")
    public Integer add(log log);
}
