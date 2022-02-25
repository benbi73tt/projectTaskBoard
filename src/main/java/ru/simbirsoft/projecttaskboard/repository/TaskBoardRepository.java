package ru.simbirsoft.projecttaskboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.simbirsoft.projecttaskboard.entity.TaskBoard;

@Repository
public interface TaskBoardRepository extends JpaRepository<TaskBoard,Long> {
}
