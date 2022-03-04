package ru.simbirsoft.projecttaskboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @JoinColumn(name = "author_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Users author;

    @JoinColumn(name = "executor_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Users executor;


    @JoinColumn(name="version_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Version version;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="taskBoard_id")
    private TaskBoard taskBoard;

    @Override
    public String toString() {
        return "Task {" +
                " name " + name + '\'' +
                " author " + author + '\'' +
                " executor " + executor + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public Users getExecutor() {
        return executor;
    }

    public void setExecutor(Users executor) {
        this.executor = executor;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTaskBoard(TaskBoard taskBoard) {
        this.taskBoard = taskBoard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
