package ru.simbirsoft.projecttaskboard.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.simbirsoft.projecttaskboard.entity.Project;

@Component("ProjectComponent")
public class ProjectDTO {
    private String name;
    private boolean status;
    private TaskBoardDTO taskBoardDTO;

    public static ProjectDTO from(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(project.getName());
        projectDTO.setStatus(project.isStatus());
        projectDTO.setTaskBoardDTO(TaskBoardDTO.from(project.getTaskBoard()));
        return projectDTO;
    }

    public Project toProject() {
        Project project = new Project();
        project.setName(this.name);
        project.setStatus(this.status);
        return project;
    }

    public TaskBoardDTO getTaskBoardDTO() {
        return taskBoardDTO;
    }

    public void setTaskBoardDTO(TaskBoardDTO taskBoardDTO) {
        this.taskBoardDTO = taskBoardDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
