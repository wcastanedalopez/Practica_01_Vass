package com.example.projecttest01.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class IdAlreadyExistsException extends ResponseStatusException {

    public IdAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}