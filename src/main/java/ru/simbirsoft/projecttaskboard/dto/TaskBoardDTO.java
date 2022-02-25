package ru.simbirsoft.projecttaskboard.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Component("TaskComponent")
public class TaskBoardDTO {
    private String name;
    private List<Task> tasks;

    public static TaskBoardDTO from(TaskBoard taskBoard) {
        TaskBoardDTO taskBoardDTO = new TaskBoardDTO();
        taskBoardDTO.setName(taskBoard.getName());
        taskBoardDTO.setTasks(taskBoard.getTasks());
        return taskBoardDTO;
    }

    public TaskBoard toTaskBoard() {
        TaskBoard taskBoard = new TaskBoard();
        taskBoard.setTasks(this.tasks);
        taskBoard.setName(this.name);
        return taskBoard;
    }
}
