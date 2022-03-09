package ru.simbirsoft.projecttaskboard.controller;


//import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.projecttaskboard.dto.*;
import ru.simbirsoft.projecttaskboard.entity.*;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/project")
public class BoardController {

    private final TaskBoardService taskBoardService;
    private final TaskService taskService;
    private final UsersService usersService;
    private final ProjectService projectService;
    private final VersionService versionService;
    Logger logger = Logger.getGlobal();

    @Autowired
    public BoardController(TaskBoardService taskBoardService,
                           TaskService taskService,
                           UsersService usersService,
                           ProjectService projectService,
                           VersionService versionService) {
        this.taskBoardService = taskBoardService;
        this.taskService = taskService;
        this.usersService = usersService;
        this.projectService = projectService;
        this.versionService = versionService;

    }

    @GetMapping()
    public ProjectDTO getProject() {
        return ProjectDTO.from(projectService.getProject());
    }

    @PostMapping()
    public Long createProject(@RequestBody Project projectDTO) {
        return projectService.createProject(projectDTO);
    }

    @PutMapping()
    public ResponseEntity updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity deleteProject() {
        projectService.deleteProject(1L);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/taskBoard")
    public Long createTaskBoard(@RequestBody TaskBoard taskBoard) {
        taskBoard.setProject(projectService.getProject());
        return taskBoardService.createBoard(taskBoard);
    }

    @GetMapping("/taskBoard/{id}")
    public TaskBoardDTO taskBoard(@PathVariable Long id) {
        return TaskBoardDTO.from(taskBoardService.getTaskBoard(id));
    }

    @PutMapping("/taskBoard/{id}")
    public ResponseEntity updateTaskBoard(@PathVariable Long id,
                                          @RequestBody TaskBoard taskBoard) {
        taskBoardService.updateTaskBoard(id, taskBoard);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/taskBoard/{id}")
    public ResponseEntity deleteTaskBoard(@PathVariable Long id) {
        taskBoardService.deleteTaskBoard(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("taskBoard/{id}/task")
    public ResponseEntity addTask(@RequestBody TaskDTO taskDTO,
                                  @PathVariable(name = "id") Long id
    ) {
        Task task = taskDTO.toTask();
        logger.info("Прикрепление задачи к доске задач с id: " + id);
        task.setTaskBoard(taskBoardService.getTaskBoard(id));

        taskService.addTask(task, taskDTO.getAuthor_id(), taskDTO.getExecutor_id());
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

    @PostMapping("/version")
    public Long createVersion(@RequestBody Version version) {
        return versionService.createVersion(version);
    }

    @GetMapping("/version/{id}")
    public VersionDTO getVersion(@PathVariable Long id) {
        return VersionDTO.from(versionService.getVersion(id));
    }

    @PutMapping("/version/{id}")
    public ResponseEntity updateVersion(@PathVariable Long id,
                                        @RequestBody Version version) {
        versionService.updateVersion(id, version);
        return ResponseEntity.ok().build();
    }
}
