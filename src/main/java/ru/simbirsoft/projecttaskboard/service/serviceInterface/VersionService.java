package ru.simbirsoft.projecttaskboard.service.serviceInterface;

import ru.simbirsoft.projecttaskboard.entity.Version;

public interface VersionService {

    Long createVersion(Version version);
    Version getVersion(Long id);
    void deleteVersion(Long id);
    void updateVersion(Long id, Version version);
}
