package ru.simbirsoft.projecttaskboard.exception;

public class NotFoundUserIdException extends AppException{
    public NotFoundUserIdException(Long id) {
        super("User this id: "+ id + " not found");
    }
}
