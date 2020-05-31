package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<Project> checkProjectName(String project_name);
    Boolean insertProject(Project project);
    List<Project> listProject();
}
