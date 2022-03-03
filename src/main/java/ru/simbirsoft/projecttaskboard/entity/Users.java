package ru.simbirsoft.projecttaskboard.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String pass;


    @OneToOne()
    @JoinColumn(name = "executor_id")
    private Task taskExecutor;

    @OneToOne()
    @JoinColumn(name = "author_id")
    private Task taskAuthor;

    public Task getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(Task taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public Task getTaskAuthor() {
        return taskAuthor;
    }

    public void setTaskAuthor(Task taskAuthor) {
        this.taskAuthor = taskAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
