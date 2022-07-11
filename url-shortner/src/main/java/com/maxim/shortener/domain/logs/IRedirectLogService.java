package com.maxim.shortener.domain.logs;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;
import com.maxim.shortener.infrastructure.model.RedirectLog;

import java.util.List;

public interface IRedirectLogService {
    List<RedirectLog> getLogs(String urlKey);
}
