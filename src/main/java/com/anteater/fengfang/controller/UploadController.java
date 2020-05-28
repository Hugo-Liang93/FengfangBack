package com.anteater.fengfang.controller;

import com.anteater.fengfang.domains.Project;
import com.anteater.fengfang.service.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {
    private static Logger logger= Logger.getLogger(UploadController.class);
    @Autowired
    ProjectService projectService;

    @RequestMapping("/api/project/listProject")
    @ResponseBody
    public List<Project> listProject(@RequestBody Project project){
        return null;
    }

    @RequestMapping("/api/project/initProject")
    @ResponseBody
    public Boolean initProject(@RequestBody Project project){
        return projectService.initProject(project);
    }

    @RequestMapping("/upload/{file_type}/{project_name}")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,@PathVariable String project_name,@PathVariable String file_type, HttpServletRequest req) throws IOException {
        if(file.isEmpty()){
            return "failed";
        }
        // 获取文件存储路径（绝对路径）
        String path = req.getServletContext().getRealPath("/WEB-INF/file");
        // 获取原文件名
        String fileName = file_type+"_"+project_name+"_"+file.getOriginalFilename();
        // 创建文件实例
        File filePath = new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录" + filePath);
        }
        // 写入文件
        file.transferTo(filePath);
        return "success";
    }
}
