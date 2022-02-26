package ru.simbirsoft.projecttaskboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simbirsoft.projecttaskboard.entity.Project;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;
import ru.simbirsoft.projecttaskboard.entity.Users;
import ru.simbirsoft.projecttaskboard.repository.ProjectRepository;
import ru.simbirsoft.projecttaskboard.repository.TaskBoardRepository;
import ru.simbirsoft.projecttaskboard.repository.TaskRepository;
import ru.simbirsoft.projecttaskboard.repository.UsersRepository;

import java.util.List;


@Service
public class TaskBoardServiceImpl implements TaskBoardService {

    private final TaskBoardRepository taskBoardRepository;
    private final TaskRepository taskRepository;
    private final UsersRepository usersRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public TaskBoardServiceImpl(ProjectRepository projectRepository,
                                TaskBoardRepository taskBoardRepository,
                                TaskRepository taskRepository,
                                UsersRepository usersRepository) {
        this.taskBoardRepository = taskBoardRepository;
        this.taskRepository = taskRepository;
        this.usersRepository = usersRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public TaskBoard getTaskBoard(Long id) {
        return taskBoardRepository.findById(id).orElse(null);
    }

    @Override
    public Users getUser(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Long createProject(Project project) {
        projectRepository.save(project);
        return project.getId();
    }

    @Override
    public Project getProject() {
        return projectRepository.findById(1L).orElse(null);

    }

    @Override
    public Long createBoard(TaskBoard taskBoard) {
        taskBoard.setProject(getProject());
        taskBoardRepository.save(taskBoard);
        return taskBoard.getId();
    }


    @Override
    public Long addTask(Task task, Long id) {
        task.setTaskBoard(getTaskBoard(id));
        taskRepository.save(task);
        return task.getId();
    }


    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task findTask(Long task_id) {
        return null;
    }

    @Override
    public Long createUser(Users user) {
        usersRepository.save(user);
        return user.getId();
    }

    @Override
    public Users findUser(Long id) {
        return usersRepository.findById(id).orElse(null);
    }


}
