package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.notice;

import java.util.List;

public interface noticeService {
    IPage<notice> findAll(Page<notice> page);

    IPage<notice> selectByTitle(Page<notice> page, String title);

    IPage<notice> selectByState(Page<notice> page, String state);

    IPage<notice> selectByTitleAndState(Page<notice> page, String title, String state);

    public Integer deleteById(Integer noticeId);

    public Integer update(Integer noticeId, notice notice);

    public Integer updateState(Integer noticeId, String state);

    public Integer add(notice notice);

}
