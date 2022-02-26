package ru.simbirsoft.projecttaskboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
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

//
//    @JoinColumn(name="release_id")
//    @OneToOne(cascade = CascadeType.ALL)
//    private Release release;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="taskBoard_id")
    private TaskBoard taskBoard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
