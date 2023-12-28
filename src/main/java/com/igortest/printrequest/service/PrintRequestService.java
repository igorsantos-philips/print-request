package com.igortest.printrequest.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
@Service
public class PrintRequestService {
	@Autowired
	private JsonRequestGenService jsonRequestGenService;
	@Autowired
	private LogRequest logRequest;
	
	public JSONObject printRequest(HttpMethod httpMethod, String requestBody, HttpHeaders headers, String queryParams) {
	    JSONObject jsonObject = jsonRequestGenService.generateJsonObject(httpMethod, requestBody, headers, queryParams);
		logRequest.register(jsonObject);
		return jsonObject;
				
	}

}
