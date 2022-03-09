package ru.simbirsoft.projecttaskboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.simbirsoft.projecttaskboard.entity.*;
import ru.simbirsoft.projecttaskboard.exception.NotFoundTaskBoardIdException;
import ru.simbirsoft.projecttaskboard.repository.*;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.TaskBoardService;


@Service
public class TaskBoardServiceImpl implements TaskBoardService {

    private final TaskBoardRepository taskBoardRepository;

    @Autowired
    public TaskBoardServiceImpl(
            TaskBoardRepository taskBoardRepository) {
        this.taskBoardRepository = taskBoardRepository;
    }


    //todo TASK_BOARD
    @Override
    public TaskBoard getTaskBoard(Long id) {
        return taskBoardRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Long createBoard(TaskBoard taskBoard) {
        taskBoard.getProject().setTaskBoard(taskBoard);
        taskBoardRepository.save(taskBoard);
        return taskBoard.getId();
    }

    @Override
    public void updateTaskBoard(Long id, TaskBoard taskBoard) {
        taskBoard.setId(id);
        taskBoardRepository.save(taskBoard);
    }

    @Override
    public void deleteTaskBoard(Long id) {
        taskBoardRepository.findById(id).orElseThrow(() -> new NotFoundTaskBoardIdException(id));
        taskBoardRepository.deleteById(id);
    }
}
