package ru.simbirsoft.projecttaskboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import ru.simbirsoft.projecttaskboard.entity.Status;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;
import ru.simbirsoft.projecttaskboard.entity.Users;

@Data
public class TaskDTO {
    private String name;
    private Status status;
    private UsersDTO author;
    private UsersDTO executor;

    private long author_id;
    private long executor_id;


    public static TaskDTO from(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName(task.getName());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setAuthor(UsersDTO.from(task.getAuthor()));
        taskDTO.setExecutor(UsersDTO.from(task.getExecutor()));

        return taskDTO;
    }

    public Task toTask() {
        Task task = new Task();
        task.setName(this.name);
        task.setAuthor(this.author.toUsers());
        task.setExecutor(this.executor.toUsers());
        task.setStatus(this.status);
        return task;
    }
}
