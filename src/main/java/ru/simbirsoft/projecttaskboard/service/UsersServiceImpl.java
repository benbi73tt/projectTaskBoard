package ru.simbirsoft.projecttaskboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.simbirsoft.projecttaskboard.entity.Users;
import ru.simbirsoft.projecttaskboard.exception.NotFoundUserIdException;
import ru.simbirsoft.projecttaskboard.repository.UsersRepository;
import ru.simbirsoft.projecttaskboard.service.serviceInterface.UsersService;


@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    //todo USER
    @Override
    @Transactional
    public Long createUser(Users user) {
        usersRepository.save(user);
        return user.getId();
    }

    @Override
    public Users findUser(Long id) {
        return usersRepository.findById(id).orElse(new Users());
    }
    @Override
    public Users getUser(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public void updateUser(Long id, Users users) {
        users.setId(id);
        usersRepository.save(users);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.findById(id).orElseThrow(() -> new NotFoundUserIdException(id));
        usersRepository.deleteById(id);
    }
}
