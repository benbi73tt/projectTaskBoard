package ru.simbirsoft.projecttaskboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.simbirsoft.projecttaskboard.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
