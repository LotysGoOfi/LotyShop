package by.itacademy.lotys.web.shop.lotyshop.controllers;

import by.itacademy.lotys.web.shop.lotyshop.dtos.exceptions.ExceptionResponse;
import by.itacademy.lotys.web.shop.lotyshop.exceptions.ExceptionEmailExists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionsHandlerController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionResponse handlerNotFoundException(EntityNotFoundException exception){
        return ExceptionResponse.builder()
                .massage(exception.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ExceptionEmailExists.class)
    public ExceptionResponse handlerEmailExistsException(ExceptionEmailExists exception){
        return ExceptionResponse.builder()
                .massage(exception.getMessage()).build();
    }
}