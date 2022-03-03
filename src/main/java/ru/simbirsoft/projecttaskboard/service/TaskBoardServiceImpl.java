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
    private final ProjectRepository projectRepository;
    private final VersionRepository versionRepository;


    @Autowired
    public TaskBoardServiceImpl(ProjectRepository projectRepository,
                                TaskBoardRepository taskBoardRepository,
                                VersionRepository versionRepository) {
        this.taskBoardRepository = taskBoardRepository;
        this.projectRepository = projectRepository;
        this.versionRepository = versionRepository;
    }

    //todo Version
    @Override
    @Transactional
    public Long createVersion(Version version) {
        versionRepository.save(version);
        return version.getId();
    }

    @Override
    public Version getVersion(Long id) {
        return versionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVersion(Long id) {
        versionRepository.deleteById(id);
    }

    @Override
    public void updateVersion(Long id, Version version) {
        version.setId(id);
        versionRepository.save(version);
    }


    //todo PROJECT
    @Override
    @Transactional
    public Long createProject(Project project) {
        projectRepository.save(project);
        return project.getId();
    }

    @Override
    public Project getProject() {
        return projectRepository.findById(1L).orElse(null);

    }

    @Override
    public void updateProject(Project project) {
        project.setId(1L);
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }


    //todo TASK_BOARD
    @Override
    public TaskBoard getTaskBoard(Long id) {
        return taskBoardRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Long createBoard(TaskBoard taskBoard) {
        taskBoard.setProject(getProject());
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
