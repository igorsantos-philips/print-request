package com.igortest.printrequest.service;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class LogRequest implements RegisterRequestInterface {
    Logger logger = LoggerFactory.getLogger(LogRequest.class);

    @Override
    public void register(JSONObject request) {
        logger.info(request.toString());

    }

}
