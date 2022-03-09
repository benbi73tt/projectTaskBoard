package ru.simbirsoft.projecttaskboard.dto;

import ru.simbirsoft.projecttaskboard.entity.Users;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
