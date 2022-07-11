package com.maxim.shortener.domain.url;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;

public interface IUrlShortenerService {
    String generateShortUrl(GenerateShortUrlRequest request);
    String getOriginalUrl(String urlKey);
}
