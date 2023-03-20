package org.server.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.log;
import org.server.entity.log;
import org.server.mapper.logMapper;
import org.server.service.logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class logServiceImpl implements logService {
    @Autowired
    private org.server.mapper.logMapper logMapper;

    @Override
    public IPage<log> findAll(Page<log> page) {
        return logMapper.findAll(page);
    }

    @Override
    public void add(log log) {
        logMapper.add(log);
    }
}
