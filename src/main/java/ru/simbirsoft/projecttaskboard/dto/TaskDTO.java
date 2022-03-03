package ru.simbirsoft.projecttaskboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.simbirsoft.projecttaskboard.entity.Status;
import ru.simbirsoft.projecttaskboard.entity.Task;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;
import ru.simbirsoft.projecttaskboard.entity.Users;

import java.util.List;

public class TaskDTO {
    private String name;
    private Status status;
    private UsersDTO author;
    private UsersDTO executor;
    private VersionDTO version;


    private long author_id;
    private long executor_id;


    public static TaskDTO from(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName(task.getName());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setAuthor(UsersDTO.from(task.getAuthor()));
        taskDTO.setExecutor(UsersDTO.from(task.getExecutor()));
        taskDTO.setVersion(VersionDTO.from(task.getVersion()));

        taskDTO.setAuthor_id(task.getAuthor().getId());
        taskDTO.setExecutor_id(task.getExecutor().getId());


        return taskDTO;
    }

    public Task toTask() {
        Task task = new Task();
        task.setName(this.name);

        if (this.author != null)
            task.setAuthor(this.author.toUsers());
        if (this.executor != null)
            task.setExecutor(this.executor.toUsers());

        task.setStatus(this.status);
        if (this.version != null)
            task.setVersion(this.version.toVersion());

        return task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UsersDTO getAuthor() {
        return author;
    }

    public void setAuthor(UsersDTO author) {
        this.author = author;
    }

    public UsersDTO getExecutor() {
        return executor;
    }

    public void setExecutor(UsersDTO executor) {
        this.executor = executor;
    }

    public VersionDTO getVersion() {
        return version;
    }

    public void setVersion(VersionDTO version) {
        this.version = version;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public long getExecutor_id() {
        return executor_id;
    }

    public void setExecutor_id(long executor_id) {
        this.executor_id = executor_id;
    }
}
