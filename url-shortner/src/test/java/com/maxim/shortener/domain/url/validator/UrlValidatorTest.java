package com.maxim.shortener.domain.url.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UrlValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "https://www.google.com",
            "https://stackoverflow.com",
            "https://www.amazonn.com?q=tv&p=8",
    })
    void shouldBeValid(String url) {
        assertTrue(UrlValidatorUtils.isValid(url));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "https://www.google com",
            "https://stackoverflow com",
            "10.0.0.1",
            "just some string",
            "just",
            ""
    })
    void shouldBeInvalid(String url) {
        assertFalse(UrlValidatorUtils.isValid(url));
    }
}