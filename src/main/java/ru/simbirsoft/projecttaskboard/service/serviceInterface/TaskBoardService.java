package ru.simbirsoft.projecttaskboard.service.serviceInterface;

import ru.simbirsoft.projecttaskboard.dto.TaskDTO;
import ru.simbirsoft.projecttaskboard.dto.UsersDTO;
import ru.simbirsoft.projecttaskboard.entity.*;

import java.util.List;

public interface TaskBoardService {
    Long createVersion(Version version);
    Version getVersion(Long id);
    void deleteVersion(Long id);
    void updateVersion(Long id, Version version);


    Long createProject(Project project);
    Project getProject();
    void deleteProject(Long id);
    void updateProject(Project project);



    Long createBoard(TaskBoard taskBoard);
    TaskBoard getTaskBoard(Long id);
    void deleteTaskBoard(Long id);
    void updateTaskBoard(Long id, TaskBoard taskBoard);









}
