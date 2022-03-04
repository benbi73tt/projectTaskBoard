package ru.simbirsoft.projecttaskboard.service.serviceInterface;

import ru.simbirsoft.projecttaskboard.dto.TaskDTO;
import ru.simbirsoft.projecttaskboard.dto.UsersDTO;
import ru.simbirsoft.projecttaskboard.entity.*;

import java.util.List;

public interface TaskBoardService {

    Long createBoard(TaskBoard taskBoard);
    TaskBoard getTaskBoard(Long id);
    void deleteTaskBoard(Long id);
    void updateTaskBoard(Long id, TaskBoard taskBoard);









}
