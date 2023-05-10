package com.akbulutmehmet.enocaassignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerException extends RuntimeException{
    public CustomerException(String message) {
        super(message);
    }
}
