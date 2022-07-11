package com.maxim.shortener.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidUrlToShortenException extends RuntimeException {
    public InvalidUrlToShortenException() {
        super("Cannot shorten an invalid url");
    }
}
