package ru.simbirsoft.projecttaskboard.service.serviceInterface;

import ru.simbirsoft.projecttaskboard.entity.Task;

public interface TaskService {

    Long addTask(Task task, Long author, Long executor);
    Task getTask(Long id);
    void deleteTask(Long id);
    void updateTask(Long id, Task task, Long author,Long executor);
}
