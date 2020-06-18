package com.anteater.fengfang.controller;

import com.anteater.fengfang.domains.Detail;
import com.anteater.fengfang.domains.Project;
import com.anteater.fengfang.service.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UploadController {
    private static Logger logger= Logger.getLogger(UploadController.class);
    @Autowired
    ProjectService projectService;

    @RequestMapping("/api/project/listProject")
    @ResponseBody
    public List<Project> listProject(){
        return projectService.listProject();
    }

    @RequestMapping("/api/project/initProject")
    @ResponseBody
    public String initProject(@RequestBody Project project){
        return projectService.initProject(project);
    }

    @RequestMapping("/api/project/updateProject")
    @ResponseBody
    public Boolean updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }

    @RequestMapping("/upload/{file_type}/{project_id}")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,@PathVariable String project_id,@PathVariable String file_type, HttpServletRequest req) throws IOException {
        if(file.isEmpty() || project_id == null){
            return "failed";
        }
        // 获取文件存储路径（绝对路径）
        String path = req.getServletContext().getRealPath("/WEB-INF/file");
        // 获取原文件名
        String fileName = project_id+"_"+file_type+"_"+file.getOriginalFilename();
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

    @RequestMapping("/api/project/getFiles/{project_id}")
    @ResponseBody
    public Map<String,List<String>> getFiles(@PathVariable String project_id, HttpServletRequest req){
        Map<String,List<String>> resMap = new HashMap<>();
        List<String> attachList = new ArrayList<>();
        List<String> houseTypeList = new ArrayList<>();
        String path = req.getServletContext().getRealPath("/WEB-INF/file");
        File filePath = new File(path);
        File[] temList = filePath.listFiles();
        for(File file: temList){
            if(file.isFile() && file.getName().split("_")[0].equals(project_id)){
                logger.info(file.getName().split("_")[1]);
                if(file.getName().split("_")[1].equals("attach")){
                    attachList.add(file.getName());
                }else houseTypeList.add(file.getName());
            }
        }
        resMap.put("attach",attachList);
        resMap.put("houseType",houseTypeList);
        return resMap;
    }

    @RequestMapping("/api/project/getPic/")
    @ResponseBody
    public List<String> getFiles( HttpServletRequest req){
        List<String> resList = new ArrayList<>();
        String path = req.getServletContext().getRealPath("/WEB-INF/file");
        File filePath = new File(path);
        File[] temList = filePath.listFiles();
        for(File file: temList){
            if(file.isFile() && file.getName().split("_")[1].equals("houseType")){
                resList.add(file.getName());
            }
        }
        return resList;
    }

    @RequestMapping("/api/download")
    public ResponseEntity<byte[]> fileDownLoad(@RequestBody String fileName,HttpServletRequest req) throws Exception{
        logger.info(fileName);
        String path = req.getServletContext().getRealPath("/WEB-INF/file/"+fileName);
        InputStream in=new FileInputStream(new File(path));//将该文件加入到输入流之中
        byte[] body=null;
        body=new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
        in.read(body);//读入到输入流里面

        fileName=new String(fileName.getBytes("utf-8"),"iso8859-1");//防止中文乱码
        HttpHeaders headers=new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename="+fileName);
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

    @RequestMapping("/api/project/delete")
    @ResponseBody
    public Boolean removeProject(@RequestBody String projectId, HttpServletRequest req){
        String path = req.getServletContext().getRealPath("/WEB-INF/file");
        if(projectService.removeProject(projectId)){
            File filePath = new File(path);
            File[] temList = filePath.listFiles();
            for(File file: temList){
                if(file.isFile() && file.getName().split("_")[0].equals(projectId)){
                    file.delete();
                }
            }
            return true;
        } else return false;
    }

    @RequestMapping("/api/Detail/saveDetail")
    @ResponseBody
    public Boolean saveDetail(@RequestBody Detail detail){
        return projectService.saveDetail(detail);
    }

    @RequestMapping("/api/Detail/getDetail")
    @ResponseBody
    public List<Detail> getDetail(){
        return projectService.getDetail();
    }

    @RequestMapping("/api/Detail/delete")
    @ResponseBody
    public Boolean removeDetail(@RequestBody String detailId){
        logger.info(detailId);
        return projectService.removeDetail(detailId);
    }
}
