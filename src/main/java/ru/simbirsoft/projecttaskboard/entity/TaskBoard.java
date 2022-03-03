package ru.simbirsoft.projecttaskboard.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TaskBoard")
public class TaskBoard extends TaskManager<Task> {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "project")
    @OneToOne(cascade = CascadeType.ALL)
    private Project project;

    @Value("Simbirsoft")
    @NotNull
    @Column(name = "name")
    private String name;

    public TaskBoard(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task board {" +
                "name" + name + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskBoard() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

