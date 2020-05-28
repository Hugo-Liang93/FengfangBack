package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.Project;

import java.util.List;

public interface ProjectService {
    public Boolean initProject(Project project);
    List<Project> listProject();
}
