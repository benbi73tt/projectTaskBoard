package ru.simbirsoft.projecttaskboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "release")
public class Release {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="date_start")
    private LocalDateTime dateStart;

    @Column(name="date_end")
    private LocalDateTime dateEnd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
