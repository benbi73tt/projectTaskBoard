package ru.simbirsoft.projecttaskboard.service;

import ru.simbirsoft.projecttaskboard.entity.Project;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;
import ru.simbirsoft.projecttaskboard.entity.Users;

import java.util.List;

public interface TaskBoardService {
    Long createProject(Project project);
    Project getProject();
    Long createBoard(TaskBoard taskBoard);
    TaskBoard getTaskBoard(Long id);
    Long addTask(Task task, Long id);
    Task getTask(Long id);
    List<Task> getTasks();
    Users getUser(Long id);
    Task findTask(Long task_id);
    Long createUser(Users user);
    Users findUser(Long user_id);
}
