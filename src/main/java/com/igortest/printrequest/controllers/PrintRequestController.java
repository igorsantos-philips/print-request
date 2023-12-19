package com.igortest.printrequest.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igortest.printrequest.exceptions.PrintRequestException;

@Controller
@RequestMapping("/printRequest")
public class PrintRequestController {
    @PostMapping("/test")
    public ResponseEntity<String> testPrintPostRequest(final RequestEntity<String> request){
        return ResponseEntity.ok("teste ok");
    }
    
    @PostMapping
    public ResponseEntity<String> printPostRequest(final RequestEntity<String> request){
        final String body = request.hasBody()?request.getBody():"The request body is null";
        return printRequest(HttpMethod.POST, body, request.getHeaders(),request.getUrl().getQuery());
    }
    @GetMapping
    public ResponseEntity<String> printGetRequest(final RequestEntity<String> request){
        final String body = request.hasBody()?request.getBody():"The request body is null, That is correct. The http method GET shouldn't have body";
        return printRequest(HttpMethod.GET, body, request.getHeaders(),request.getUrl().getQuery());
    } 
    private ResponseEntity<String> printRequest(HttpMethod httpMethod, String requestBody, HttpHeaders headers, String queryParams){
        try {
            final JSONObject responseBody = new JSONObject();
            responseBody.put("http_method", httpMethod.name());
            responseBody.put("request_body", requestBody );
            responseBody.put("request_headers",headers);
            responseBody.put("queryParams", queryParams);
            return  ResponseEntity.ok(responseBody.toString());
        } catch (JSONException e) {
            throw new PrintRequestException(e);
        }
    }
}
