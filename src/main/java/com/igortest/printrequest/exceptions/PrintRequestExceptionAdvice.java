package com.igortest.printrequest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PrintRequestExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(PrintRequestException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String employeeNotFoundHandler(PrintRequestException ex) {
      return ex.getMessage();
    }
}
