package ru.simbirsoft.projecttaskboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.exception.NotFoundTaskIdException;
import ru.simbirsoft.projecttaskboard.repository.*;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.TaskService;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.UsersService;


@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UsersService usersService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository,
                           UsersService usersService) {
        this.taskRepository = taskRepository;
        this.usersService = usersService;
    }

    //todo TASK
    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Long addTask(Task task, Long id, Long author, Long executor) {
        task.setAuthor(usersService.getUser(author));
        task.setExecutor(usersService.getUser(executor));

        task.getAuthor().setTaskAuthor(task);
        task.getExecutor().setTaskExecutor(task);

        taskRepository.save(task);
        return task.getId();
    }

    @Override
    public void updateTask(Long id, Task task, Long author, Long executor) {
        task = getTask(id);
        if(usersService.getUser(author)!=null){
            task.getAuthor().setTaskAuthor(null);
            task.setAuthor(usersService.findUser(author));
            task.getAuthor().setTaskAuthor(task);
        }

        if(usersService.getUser(executor)!=null){
            task.getExecutor().setTaskExecutor(null);
            task.setExecutor(usersService.findUser(executor));
            task.getExecutor().setTaskExecutor(task);
        }



        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundTaskIdException(id));
        task.getExecutor().setTaskExecutor(null);
        task.getAuthor().setTaskAuthor(null);
        taskRepository.delete(task);
    }
}
