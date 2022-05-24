package com.example.joinquery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NullPointerException extends RuntimeException {
    public NullPointerException(String message) {
        super(message);
    }
}
