package ru.simbirsoft.projecttaskboard.dto;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;


import java.util.List;
import java.util.stream.Collectors;

@Component("TaskBoardComponent")
public class TaskBoardDTO {
    private String name;
    private List<TaskDTO> tasks;

    public static TaskBoardDTO from(TaskBoard taskBoard) {
        TaskBoardDTO taskBoardDTO = new TaskBoardDTO();
        taskBoardDTO.setName(taskBoard.getName());

        List<TaskDTO> taskDTOList = taskBoard.getTasks().stream()
                .map(TaskDTO::from)
                .collect(Collectors.toList());


        taskBoardDTO.setTasks(taskDTOList);

        return taskBoardDTO;
    }

    public TaskBoard toTaskBoard() {

        TaskBoard taskBoard = new TaskBoard(this.name);
        taskBoard.setName(this.name);

        if (!CollectionUtils.isEmpty(this.tasks)) {
            List<Task> tasks = this.tasks.stream()
                    .map(TaskDTO::toTask)
                    .peek(e -> e.setTaskBoard(taskBoard))
                    .collect(Collectors.toList());
            taskBoard.getTasks().addAll(tasks);
        }
        return taskBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
