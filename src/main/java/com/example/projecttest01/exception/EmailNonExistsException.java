package com.example.projecttest01.exception;


public class EmailNonExistsException extends RuntimeException {

    public EmailNonExistsException(String message) {
        super(message);
    }
}