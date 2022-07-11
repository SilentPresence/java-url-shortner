package com.maxim.shortener.mvc.dto;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;

public class GenerateShortUrlFormData {
    private String userId;
    private String url;

    public GenerateShortUrlFormData() {
    }

    public GenerateShortUrlFormData(String userId, String url) {
        this.userId = userId;
        this.url = url;
    }

    public String getUserId() {
        return userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public GenerateShortUrlRequest toRequest(){
        return new GenerateShortUrlRequest(this.userId,this.url);
    }
}
