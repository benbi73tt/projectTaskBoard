package ru.simbirsoft.projecttaskboard.controller;


//import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.projecttaskboard.dto.ProjectDTO;
import ru.simbirsoft.projecttaskboard.dto.TaskBoardDTO;
import ru.simbirsoft.projecttaskboard.dto.TaskDTO;
import ru.simbirsoft.projecttaskboard.dto.UsersDTO;
import ru.simbirsoft.projecttaskboard.entity.Project;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.Users;
import ru.simbirsoft.projecttaskboard.service.TaskBoardService;


@RestController
@RequestMapping("/taskBoard")
public class BoardController {

    private final TaskBoardService taskBoardService;

    @Autowired
    public BoardController(TaskBoardService taskBoardService) {
        this.taskBoardService = taskBoardService;
    }

    @PostMapping("/project")
    public Long createProject(@RequestBody ProjectDTO projectDTO) {
        return taskBoardService.createProject(projectDTO.toProject());
    }
    @PostMapping()
    public Long createTaskBoard(@RequestBody TaskBoardDTO taskBoardDTO) {
        return taskBoardService.createBoard(taskBoardDTO.toTaskBoard());
    }

    @GetMapping("/{id}")
    public TaskBoardDTO taskBoard(@PathVariable Long id) {
        return TaskBoardDTO.from(taskBoardService.getTaskBoard(id));
    }

    @PostMapping("/{id}/task")
    public ResponseEntity addTask(@RequestBody TaskDTO task,
                                  @PathVariable(name = "id") Long id) {
        if (taskBoardService.findUser(task.getAuthor_id()) != null)
            task.setAuthor(UsersDTO.from(taskBoardService.findUser(task.getAuthor_id())));
        if (taskBoardService.findUser(task.getExecutor_id()) != null)
            task.setExecutor(UsersDTO.from(taskBoardService.findUser(task.getExecutor_id())));
        taskBoardService.addTask(task.toTask(), id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/task/{id}")
    public TaskDTO getTask(@PathVariable Long id) {
        return TaskDTO.from(taskBoardService.getTask(id));
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody Users user) {
        taskBoardService.createUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/user")
    public UsersDTO user(@PathVariable Long id) {
        return UsersDTO.from(taskBoardService.getUser(id));
    }

}
