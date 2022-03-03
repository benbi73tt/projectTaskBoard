package ru.simbirsoft.projecttaskboard.controller;


//import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.projecttaskboard.dto.*;
import ru.simbirsoft.projecttaskboard.entity.*;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.TaskBoardService;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.TaskService;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.UsersService;


@RestController
@RequestMapping("/taskBoard")
public class BoardController {

    private final TaskBoardService taskBoardService;
    private final TaskService taskService;
    private final UsersService usersService;

    @Autowired
    public BoardController(TaskBoardService taskBoardService,
                           TaskService taskService,
                           UsersService usersService) {
        this.taskBoardService = taskBoardService;
        this.taskService = taskService;
        this.usersService = usersService;

    }

    @PostMapping("/version")
    public Long createVersion(@RequestBody Version version) {
        return taskBoardService.createVersion(version);
    }

    @GetMapping("/version/{id}")
    public VersionDTO getVersion(@PathVariable Long id) {
        return VersionDTO.from(taskBoardService.getVersion(id));
    }

    @PutMapping("/version/{id}")
    public ResponseEntity updateVersion(@PathVariable Long id,
                                        @RequestBody Version version) {
        taskBoardService.updateVersion(id, version);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/project")
    public ProjectDTO getProject() {
        return ProjectDTO.from(taskBoardService.getProject());
    }

    @PostMapping("/project")
    public Long createProject(@RequestBody Project projectDTO) {
        return taskBoardService.createProject(projectDTO);
    }

    @PutMapping("/project")
    public ResponseEntity updateProject(@RequestBody Project project) {
        taskBoardService.updateProject(project);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/project")
    public ResponseEntity deleteProject() {
        taskBoardService.deleteProject(1L);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public Long createTaskBoard(@RequestBody TaskBoard taskBoard) {
        return taskBoardService.createBoard(taskBoard);
    }

    @GetMapping("/{id}")
    public TaskBoardDTO taskBoard(@PathVariable Long id) {
        return TaskBoardDTO.from(taskBoardService.getTaskBoard(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTaskBoard(@PathVariable Long id,
                                          @RequestBody TaskBoard taskBoard) {
        taskBoardService.updateTaskBoard(id, taskBoard);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTaskBoard(@PathVariable Long id) {
        taskBoardService.deleteTaskBoard(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/task")
    public ResponseEntity addTask(@RequestBody TaskDTO taskDTO,
                                  @PathVariable(name = "id") Long id
    ) {
        taskDTO.setAuthor(UsersDTO.from(usersService.getUser(taskDTO.getAuthor_id())));
        taskDTO.setExecutor(UsersDTO.from(usersService.getUser(taskDTO.getExecutor_id())));

        Task task = taskDTO.toTask();
        task.setTaskBoard(taskBoardService.getTaskBoard(id));

        taskService.addTask(task, id, taskDTO.getAuthor_id(), taskDTO.getExecutor_id());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/task/{id}")
    public TaskDTO getTask(@PathVariable Long id) {
        return TaskDTO.from(taskService.getTask(id));
    }

    @PutMapping("/task/{id}")
    public ResponseEntity updateTask(@PathVariable Long id,
                                     @RequestBody TaskDTO task) {
        taskService.updateTask(id, task.toTask(), task.getAuthor_id(), task.getExecutor_id());
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user")
    public Long createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }


    @GetMapping("/user/{id}")
    public UsersDTO user(@PathVariable Long id) {
        return UsersDTO.from(usersService.findUser(id));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity updateUser(@PathVariable Long id,
                                     @RequestBody Users users) {
        usersService.updateUser(id, users);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
