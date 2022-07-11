package com.maxim.shortener.api.dto;

public record GenerateShortUrlRequest(String userId, String url) {
}
