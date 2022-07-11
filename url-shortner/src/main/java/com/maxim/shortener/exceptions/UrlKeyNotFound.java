package com.maxim.shortener.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UrlKeyNotFound extends RuntimeException {
    public UrlKeyNotFound() {
        super("The provided shortened url does not exist");
    }
}
