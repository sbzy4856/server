package org.server.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.notice;
import org.server.mapper.noticeMapper;
import org.server.mapper.noticeMapper;
import org.server.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.CredentialsUtil;

import java.util.List;

@Service
public class noticeServiceImpl implements noticeService {
    @Autowired
    private org.server.mapper.noticeMapper noticeMapper;

    @Override
    public IPage<notice> findAll(Page<notice> page) {
        return noticeMapper.findAll(page);
    }

    public IPage<notice> selectByTitle(Page<notice> page, String title) {
        return noticeMapper.selectByTitle(page, title);
    }

    public IPage<notice> selectByState(Page<notice> page, String state) {
        return noticeMapper.selectByState(page, state);
    }

    public IPage<notice> selectByTitleAndState(Page<notice> page, String title, String state) {
        return noticeMapper.selectByTitleAndState(page, title, state);
    }

    @Override
    public Integer deleteById(Integer noticeId) {
        return noticeMapper.deleteById(noticeId);
    }

    @Override
    public Integer update(Integer noticeId, notice notice) {
        return noticeMapper.update(noticeId, notice);
    }

    public Integer updateState(Integer noticeId, String noticeState) {
        return noticeMapper.updateState(noticeId, noticeState);
    }

    @Override
    public Integer add(notice notice) {
        return noticeMapper.add(notice);
    }
}
