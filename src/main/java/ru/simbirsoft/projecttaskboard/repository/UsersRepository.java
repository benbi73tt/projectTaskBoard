package ru.simbirsoft.projecttaskboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.simbirsoft.projecttaskboard.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
}
