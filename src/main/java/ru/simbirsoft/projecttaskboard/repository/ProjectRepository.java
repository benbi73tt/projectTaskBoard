package ru.simbirsoft.projecttaskboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.simbirsoft.projecttaskboard.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
