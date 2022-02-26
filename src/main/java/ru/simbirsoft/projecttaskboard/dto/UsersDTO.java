package ru.simbirsoft.projecttaskboard.dto;

import lombok.Data;
import ru.simbirsoft.projecttaskboard.entity.Users;

@Data
public class UsersDTO {
    private String name;

    public static UsersDTO from(Users users) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setName(users.getName());
        return usersDTO;
    }

    public Users toUsers() {
        Users users = new Users();
        users.setName(this.name);
        return users;
    }
}
