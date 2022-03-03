package ru.simbirsoft.projecttaskboard.exception;

public class NotFoundTaskIdException extends AppException{
    public NotFoundTaskIdException(Long id) {
        super("Task this id: "+ id + " not found");
    }
}
