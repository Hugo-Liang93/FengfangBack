package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.controller.UploadController;
import com.anteater.fengfang.domains.Project;
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
    @Override
    public Boolean initProject(Project project) {
        List<Project> searchProject = projectMapper.checkProjectName(project.getProject_name());
        if(searchProject.size()==0){
            projectMapper.insertProject(project);
            if (project.getProject_id() == null){
                return false;
            }else return true;
        }
        return false;
    }

    @Override
    public List<Project> listProject() {
        return projectMapper.listProject();
    }
}
