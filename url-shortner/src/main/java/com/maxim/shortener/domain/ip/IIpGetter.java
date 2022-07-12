package com.maxim.shortener.domain.ip;

public interface IIpGetter {
    /**
     * Get the ip of the client
     *
     * @return ip of the client
     */
    String getCurrentUserIp();
}
