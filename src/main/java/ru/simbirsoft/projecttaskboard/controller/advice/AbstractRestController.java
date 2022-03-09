package ru.simbirsoft.projecttaskboard.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.simbirsoft.projecttaskboard.exception.AppException;

@RestControllerAdvice
public class AbstractRestController {

    @ExceptionHandler({AppException.class})
    public ResponseEntity<String> handleAppException(AppException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
