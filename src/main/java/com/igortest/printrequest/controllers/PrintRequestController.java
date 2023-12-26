package com.igortest.printrequest.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igortest.printrequest.exceptions.PrintRequestException;
import com.igortest.printrequest.service.JsonRequestGenService;

@Controller
@RequestMapping("/printRequest")
public class PrintRequestController {
    @Autowired
    private JsonRequestGenService jsonGen;
    @PostMapping("/test")
    public ResponseEntity<String> testPrintPostRequest(final RequestEntity<String> request){
        return ResponseEntity.ok("teste ok");
    }
    
    @PostMapping
    public ResponseEntity<String> printPostRequest(final RequestEntity<String> request){
        final String body = request.hasBody()?request.getBody():"The request body is null";
        return ResponseEntity.ok(jsonGen.generateJsonObject(HttpMethod.POST, body, request.getHeaders(),request.getUrl().getQuery()).toString());
    }
    @GetMapping
    public ResponseEntity<String> printGetRequest(final RequestEntity<String> request){
        final String body = request.hasBody()?request.getBody():"The request body is null, That is correct. The http method GET shouldn't have body";
        return ResponseEntity.ok(jsonGen.generateJsonObject(HttpMethod.GET, body, request.getHeaders(),request.getUrl().getQuery()).toString());
    } 
}
