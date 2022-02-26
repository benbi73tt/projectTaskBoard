package ru.simbirsoft.projecttaskboard.dto;

import lombok.Data;
import ru.simbirsoft.projecttaskboard.entity.Project;
import ru.simbirsoft.projecttaskboard.entity.Users;

@Data
public class ProjectDTO {
    private String name;
    private boolean status;

    public static ProjectDTO from(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(project.getName());
        projectDTO.setStatus(projectDTO.isStatus());
        return projectDTO;
    }

    public Project toProject() {
        Project project = new Project();
        project.setName(this.name);
        project.setStatus(this.status);
        return project;
    }
}
