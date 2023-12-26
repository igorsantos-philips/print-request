package com.igortest.printrequest.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public interface RegisterRequestInterface {
    public void register(HttpMethod httpMethod, String requestBody, HttpHeaders headers, String queryParams);
}
