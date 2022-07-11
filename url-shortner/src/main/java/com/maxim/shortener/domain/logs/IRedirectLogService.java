package com.maxim.shortener.domain.logs;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;
import com.maxim.shortener.infrastructure.model.RedirectLog;

import java.util.List;

public interface IRedirectLogService {
    /**
     * Get all the redirection logs for the provided shortened url
     * @param urlKey the shortened url
     * @return redirection log list
     */
    List<RedirectLog> getLogs(String urlKey);
}
