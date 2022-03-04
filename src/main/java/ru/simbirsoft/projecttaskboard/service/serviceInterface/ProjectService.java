package ru.simbirsoft.projecttaskboard.service.serviceInterface;

import ru.simbirsoft.projecttaskboard.entity.Project;

public interface ProjectService {

    Long createProject(Project project);
    Project getProject();
    void deleteProject(Long id);
    void updateProject(Project project);
}
