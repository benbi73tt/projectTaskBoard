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

    @Override
    public String toString() {
        return "User { " +
                " name " + name + '\'' +
                '}';
    }

    public void setTaskExecutor(Task taskExecutor) {
        this.taskExecutor = taskExecutor;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
