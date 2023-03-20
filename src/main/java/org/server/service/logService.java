package org.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.entity.log;

public interface logService {
    IPage<log> findAll(Page<log> page);

    public void add(log log);
}
