package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.notice;
import org.server.entity.ApiResult;
import org.server.serviceImpl.noticeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class noticeController {

    private noticeServiceImpl noticeServiceimpl;

    @Autowired
    public noticeController(noticeServiceImpl noticeServiceimpl) {
        this.noticeServiceimpl = noticeServiceimpl;
    }

    @GetMapping("/notice")
    public ApiResult findAll(@RequestParam("size") Integer size, @RequestParam("page") Integer page,
                             @RequestParam("title") String title, @RequestParam("state") String state) {
        Page<notice> noticePage = new Page<>(page, size);
        if (state == "" && title == "") {
            IPage<notice> noticeIPage = noticeServiceimpl.findAll(noticePage);
            return ApiResultHandler.buildApiResult(200, "查询所有公告", noticeIPage);
        } else if ("".equals(title) && !"".equals(state)) {
            IPage<notice> noticeIPage = noticeServiceimpl.selectByState(noticePage, state);
            return ApiResultHandler.buildApiResult(200, "通过状态查找", noticeIPage);
        } else if (!"".equals(title) && "".equals(state)) {
            IPage<notice> noticeIPage = noticeServiceimpl.selectByTitle(noticePage, title);
            return ApiResultHandler.buildApiResult(200, "通过标题查找", noticeIPage);
        } else {
            IPage<notice> noticeIPage = noticeServiceimpl.selectByTitleAndState(noticePage, title, state);
            return ApiResultHandler.buildApiResult(200, "通过标题和状态查找", noticeIPage);
        }
    }

    @DeleteMapping("/notice/{noticeId}")
    public ApiResult deleteById(@PathVariable("noticeId") Integer noticeId) {
        noticeServiceimpl.deleteById(noticeId);
        return ApiResultHandler.success();
    }

    @PutMapping("/notice/{noticeId}")
    public ApiResult update(@PathVariable("noticeId") Integer noticeId, @RequestBody notice notice) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        System.out.println(notice.getNoticeContent());
        return ApiResultHandler.success(noticeServiceimpl.update(noticeId, notice));
    }

    @PutMapping("/notice/state/{noticeId}")
    public ApiResult updateState(@PathVariable("noticeId") Integer noticeId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        return ApiResultHandler.success(noticeServiceimpl.updateState(noticeId, "已发布"));
    }

    @PostMapping("/notice")
    public ApiResult add(@RequestBody notice notice) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        notice.setUpdateTime(date);
        notice.setHandler("管理员");
        return ApiResultHandler.success(noticeServiceimpl.add(notice));
    }

}