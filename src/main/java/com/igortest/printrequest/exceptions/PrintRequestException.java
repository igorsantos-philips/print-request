package com.igortest.printrequest.exceptions;

import org.json.JSONException;

public class PrintRequestException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public PrintRequestException(JSONException e) {
        super(e);
    }    
  

}
