package ru.simbirsoft.projecttaskboard.controller;


//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.projecttaskboard.dto.TaskBoardDTO;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.service.TaskBoardService;


@RestController
@RequestMapping("/taskBoard")
public class BoardController {

    private final TaskBoardService taskBoardService;

    @Autowired
    public BoardController(TaskBoardService taskBoardService) {
        this.taskBoardService = taskBoardService;
    }

    @PostMapping()
    public Long createTaskBoard(@RequestBody TaskBoardDTO taskBoardDTO){
        return taskBoardService.createBoard(taskBoardDTO.toTaskBoard());
    }
    @GetMapping("/{id}")
    public TaskBoardDTO taskBoard(@PathVariable Long id){
        return TaskBoardDTO.from(taskBoardService.getTaskBoard(id));
    }

    @PostMapping("/{id}/task")
    public ResponseEntity addTask(@RequestBody Task task,
                                  @PathVariable(name = "id") Long id){
        taskBoardService.addTask(task, id);
        return ResponseEntity.ok().build();
    }
}
