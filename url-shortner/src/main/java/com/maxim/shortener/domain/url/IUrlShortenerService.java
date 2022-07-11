package com.maxim.shortener.domain.url;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;
import com.maxim.shortener.infrastructure.model.ShortenedUrl;

import java.util.List;

public interface IUrlShortenerService {
    /**
     * Generate a shortened url using the original url and the user idd
     *
     * @param request the url and user id wrapper
     * @return a shortened url
     */
    String generateShortUrl(GenerateShortUrlRequest request);

    /**
     * Get all shortened urls ever
     *
     * @return all urls
     */
    List<ShortenedUrl> getShortUrls();

    /**
     * Get the original url by that correspondes to the shortened url
     *
     * @param urlKey the shortened url key
     * @return original url
     */
    String getOriginalUrl(String urlKey);
}
