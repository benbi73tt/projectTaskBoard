package ru.simbirsoft.projecttaskboard.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "checked", nullable = false)
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    private TaskBoard project;


    public Project(String name) {
        this.name = name;
    }

    public Project() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
