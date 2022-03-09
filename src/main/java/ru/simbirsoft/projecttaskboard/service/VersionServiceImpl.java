package ru.simbirsoft.projecttaskboard.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.simbirsoft.projecttaskboard.entity.Version;
import ru.simbirsoft.projecttaskboard.repository.UsersRepository;
import ru.simbirsoft.projecttaskboard.repository.VersionRepository;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.VersionService;

@Service
public class VersionServiceImpl implements VersionService {
    private final VersionRepository versionRepository;

    @Autowired
    public VersionServiceImpl(VersionRepository versionRepository) {
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
}
