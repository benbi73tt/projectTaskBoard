package ru.simbirsoft.projecttaskboard.entity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

@MappedSuperclass
public class TaskManager<T extends Task> {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskBoard_id")
    private List<T> tasks;

    public List<T> getTasks() {
        return tasks;
    }

    public int getSize() {
        return tasks.size();
    }

}
