package ru.simbirsoft.projecttaskboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.simbirsoft.projecttaskboard.entity.Version;

@Repository
public interface VersionRepository extends CrudRepository<Version, Long> {
}
