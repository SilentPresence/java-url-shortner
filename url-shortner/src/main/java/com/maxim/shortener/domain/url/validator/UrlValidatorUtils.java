package com.maxim.shortener.domain.url.validator;

import org.apache.commons.validator.routines.UrlValidator;

public class UrlValidatorUtils {
    private static final String[] schemas = {"http", "https", "ftp"};
    private static final UrlValidator validator = new UrlValidator(schemas);

    public static boolean isValid(String url) {
        return validator.isValid(url);
    }
}