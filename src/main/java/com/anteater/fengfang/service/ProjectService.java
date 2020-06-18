package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.Detail;
import com.anteater.fengfang.domains.Project;

import java.util.List;

public interface ProjectService {
    public String initProject(Project project);
    List<Project> listProject();
    Boolean removeProject(String projectId);
    Boolean updateProject(Project project);
    Boolean saveDetail(Detail detail);
    List<Detail> getDetail();

    Boolean removeDetail(String detailId);
}
