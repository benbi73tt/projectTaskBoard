package ru.simbirsoft.projecttaskboard.exception;

public class NotFoundTaskBoardIdException extends AppException{
    public NotFoundTaskBoardIdException(Long id) {
        super("TaskBoard this id: "+ id + " not found");
    }
}
