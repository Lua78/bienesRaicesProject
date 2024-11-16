package com.api.globalState.utils.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResponseException.class)
    protected ResponseEntity<ResponseException> handleResponseException(ResponseException ex) {
        return ResponseEntity.badRequest().body(ex);
    }
}
