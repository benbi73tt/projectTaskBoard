package ru.simbirsoft.projecttaskboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;
import ru.simbirsoft.projecttaskboard.repository.TaskBoardRepository;
import ru.simbirsoft.projecttaskboard.repository.TaskRepository;
import ru.simbirsoft.projecttaskboard.repository.UsersRepository;

import java.util.List;


@Service
public class TaskBoardServiceImpl implements TaskBoardService{

    private final TaskBoardRepository taskBoardRepository;
    private final TaskRepository taskRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public TaskBoardServiceImpl(TaskBoardRepository taskBoardRepository,
                                TaskRepository taskRepository,
                                UsersRepository usersRepository) {
        this.taskBoardRepository = taskBoardRepository;
        this.taskRepository = taskRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public TaskBoard getTaskBoard(Long id){
        System.out.println(taskBoardRepository.findById(id).orElse(null));
        return taskBoardRepository.findById(id).orElse(null);
    }

    @Override
    public Long createBoard(TaskBoard taskBoard) {
        taskBoardRepository.save(taskBoard);
        return taskBoard.getId();
    }

    @Override
    public void addTask(Task task,Long id) {
        task.setTaskBoard(getTaskBoard(id));
        taskRepository.save(task);

    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task findTask(Long task_id) {
        return null;
    }


}
