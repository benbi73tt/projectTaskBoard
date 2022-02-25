package ru.simbirsoft.projecttaskboard.service;

import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;

import java.util.List;

public interface TaskBoardService {
    Long createBoard(TaskBoard taskBoard);
    TaskBoard getTaskBoard(Long id);
    void addTask(Task task, Long id);
    List<Task> getTasks();
    Task findTask(Long task_id);
}
