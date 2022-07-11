package com.maxim.shortener.domain.url;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;
import com.maxim.shortener.infrastructure.model.ShortenedUrl;

import java.util.List;

public interface IUrlShortenerService {
    String generateShortUrl(GenerateShortUrlRequest request);

    List<ShortenedUrl> getShortUrls();

    String getOriginalUrl(String urlKey);
}
