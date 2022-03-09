package ru.simbirsoft.projecttaskboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.simbirsoft.projecttaskboard.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
