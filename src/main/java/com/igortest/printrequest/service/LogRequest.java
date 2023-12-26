package com.igortest.printrequest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class LogRequest implements RegisterRequestInterface {
    Logger logger = LoggerFactory.getLogger(LogRequest.class);

    @Override
    public void register(HttpMethod httpMethod, String requestBody, HttpHeaders headers, String queryParams) {
        // TODO Auto-generated method stub

    }

}
