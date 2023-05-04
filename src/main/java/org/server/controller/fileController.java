package org.server.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.server.api.ApiResultHandler;
import org.server.entity.ApiResult;
import org.server.entity.file;
import org.server.entity.file;
import org.server.serviceImpl.courseServiceImpl;
import org.server.serviceImpl.fileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class fileController {
    private fileServiceImpl fileServiceimpl;

    @Autowired
    public fileController(fileServiceImpl fileServiceimpl) {
        this.fileServiceimpl = fileServiceimpl;
    }

    @RequestMapping(path = "/upload/teacher", method = RequestMethod.POST)
    public ApiResult teacherFileUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam Integer userId, @RequestParam Integer courseId,
                                       @RequestParam String userName, @RequestParam String courseName) throws IOException {
        java.io.File f = new java.io.File("E:\\springboot_save_file\\teacher\\");
        if (!f.exists()) {
            f.mkdir();
        }
        String fileName = "E:\\springboot_save_file\\teacher\\" + multipartFile.getOriginalFilename();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String outfileName = simpleDateFormat.format(new Date()) + "_" + UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        String outfilePath = "E:\\springboot_save_file\\teacher\\" + outfileName;
        System.out.println(outfilePath);
        java.io.File file = new java.io.File(outfilePath);
        multipartFile.transferTo(file);
        file fileEntity = new file();
        fileEntity.setOutfilePath(outfilePath);
        fileEntity.setOutfileName(outfileName);
        fileEntity.setFilePath(fileName);
        fileEntity.setFileName(multipartFile.getOriginalFilename());
        fileEntity.setType("teacher");
        fileEntity.setUserId(userId);
        fileEntity.setUserName(userName);
        fileEntity.setCourseId(courseId);
        fileEntity.setCourseName(courseName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        fileEntity.setUploadTime(date);
        fileServiceimpl.add(fileEntity);
        return ApiResultHandler.buildApiResult(200, "文件地址", outfileName);
    }

    @RequestMapping(path = "/upload/student", method = RequestMethod.POST)
    public ApiResult studentFileUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam Integer userId, @RequestParam Integer courseId,
                                       @RequestParam String userName, @RequestParam String courseName) throws IOException {
        java.io.File f = new java.io.File("E:\\springboot_save_file\\student\\");
        if (!f.exists()) {
            f.mkdir();
        }
        String fileName = "E:\\springboot_save_file\\student\\" + multipartFile.getOriginalFilename();
        java.io.File file = new java.io.File(fileName);
        multipartFile.transferTo(file);
        file fileEntity = new file();
        fileEntity.setFilePath(fileName);
        fileEntity.setFileName(multipartFile.getOriginalFilename());
        fileEntity.setType("student");
        fileEntity.setUserId(userId);
        fileEntity.setUserName(userName);
        fileEntity.setCourseId(courseId);
        fileEntity.setCourseName(courseName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        fileEntity.setUploadTime(date);
        fileServiceimpl.add(fileEntity);
        return ApiResultHandler.buildApiResult(200, "文件地址", fileName);
    }

    @RequestMapping(path = "/download/student", method = RequestMethod.GET)
    public ApiResult studentDownload(@RequestParam("file") String filePath, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(request.getSession().getServletContext().getMimeType(filePath));
        response.setHeader("Content-Disposition", "attachment;filename=" + filePath);
        try {
            InputStream in = Files.newInputStream(Paths.get(filePath));
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[1024];
            while (in.read(b) != -1) {
                out.write(b);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResultHandler.buildApiResult(200, "文件地址", response);
    }

    @GetMapping("/file")
    public ApiResult findAll(@RequestParam("size") Integer size, @RequestParam("page") Integer page, @RequestParam Integer courseId) {
        Page<file> filePage = new Page<>(page, size);
        IPage<file> fileIPage = fileServiceimpl.findAll(filePage, courseId);
        return ApiResultHandler.buildApiResult(200, "查询所有文件信息", fileIPage);
    }
}