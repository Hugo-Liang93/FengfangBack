package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.controller.UploadController;
import com.anteater.fengfang.domains.Detail;
import com.anteater.fengfang.domains.Project;
import com.anteater.fengfang.mapper.DetailMapper;
import com.anteater.fengfang.mapper.ProjectMapper;
import com.anteater.fengfang.service.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private static Logger logger= Logger.getLogger(ProjectServiceImpl.class);
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    DetailMapper detailMapper;
    @Override
    public String initProject(Project project) {
        List<Project> searchProject = projectMapper.checkProjectName(project.getProject_name());
        if(searchProject.size()==0){
            projectMapper.insertProject(project);
            if (project.getProject_id() == null){
                return null;
            }else return project.getProject_id();
        }
        return null;
    }

    @Override
    public List<Project> listProject() {
        return projectMapper.listProject();
    }

    @Override
    public Boolean removeProject(String projectId) {
        return projectMapper.removeProject(projectId);
    }

    @Override
    public Boolean updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    @Override
    public Boolean saveDetail(Detail detail) {
        detailMapper.saveDetail(detail);
        if(detail.getId()!= null){
            return true;
        }else return false;
    }

    @Override
    public List<Detail> getDetail() {
        return detailMapper.getDetail();
    }

    @Override
    public Boolean removeDetail(String detailId) {
        return detailMapper.removeDetailById(detailId);
    }

    @Override
    public Boolean updateDetail(Detail detail) {
        return detailMapper.updateDetail(detail);
    }
}
