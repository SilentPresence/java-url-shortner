package com.maxim.shortener.domain.url.validator;

import org.apache.commons.validator.routines.UrlValidator;

public class UrlValidatorUtils {
    private static final String[] schemas = {"http", "https", "ftp"};
    private static final UrlValidator validator = new UrlValidator(schemas);

    /**
     * Checks if a url is valid
     *
     * @param url a url
     * @return whether the url is valid
     */
    public static boolean isValid(String url) {
        return validator.isValid(url);
    }
}