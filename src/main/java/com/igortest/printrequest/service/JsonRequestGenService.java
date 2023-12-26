package com.igortest.printrequest.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.igortest.printrequest.exceptions.PrintRequestException;

@Service
public class JsonRequestGenService {

    public JSONObject generateJsonObject(HttpMethod httpMethod, String requestBody, HttpHeaders headers, String queryParams) {
        try {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("http_method", httpMethod.name());
            jsonObject.put("request_body", requestBody );
            jsonObject.put("request_headers",headers);
            jsonObject.put("queryParams", queryParams);
            return jsonObject;
        } catch (JSONException e) {
            throw new PrintRequestException(e);
        }
        
    }
}
