package ru.simbirsoft.projecttaskboard.service.serviceInterface;

import ru.simbirsoft.projecttaskboard.entity.Users;

public interface UsersService {

    Long createUser(Users user);
    Users findUser(Long user_id);
    Users getUser(Long id);
    void deleteUser(Long id);
    void updateUser(Long id, Users users);
}
