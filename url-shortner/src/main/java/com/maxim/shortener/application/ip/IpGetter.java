package com.maxim.shortener.application.ip;

import com.maxim.shortener.domain.ip.IIpGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class IpGetter implements IIpGetter {
    @Autowired
    HttpServletRequest request;

    @Override
    public String getCurrentUserIp() {
        return request.getRemoteAddr();
    }
}
