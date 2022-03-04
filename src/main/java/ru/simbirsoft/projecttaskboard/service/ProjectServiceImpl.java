package ru.simbirsoft.projecttaskboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.simbirsoft.projecttaskboard.entity.Project;
import ru.simbirsoft.projecttaskboard.repository.ProjectRepository;
import ru.simbirsoft.projecttaskboard.repository.UsersRepository;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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

}
