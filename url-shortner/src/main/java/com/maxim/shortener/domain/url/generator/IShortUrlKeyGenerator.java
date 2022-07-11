package com.maxim.shortener.domain.url.generator;

public interface IShortUrlKeyGenerator {
    /**
     * Generates a key for the shortened url
     *
     * @param url       the url to shorten
     * @param userId    the id of the user that wants to shorten the url
     * @param timestamp current timestamp
     * @return an url safe base64 key
     */
    String generateShortUrlKey(String url, String userId, long timestamp);

    /**
     * Generates a key for the shortened url
     *
     * @param url    the url to shorten
     * @param userId the id of the user that wants to shorten the url
     * @return an url safe base64 key
     */
    String generateShortUrlKey(String url, String userId);
}
