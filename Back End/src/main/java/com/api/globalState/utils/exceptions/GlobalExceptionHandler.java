package com.api.globalState.utils.exceptions;

import com.api.globalState.utils.GenericResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResponseException.class)
    protected ResponseEntity<GenericResponse> handleResponseException(ResponseException ex) {
        return ResponseEntity.badRequest().body(new GenericResponse<>(ex.getMessage()));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    protected ResponseEntity<GenericResponse> handleIntegrityException(ResponseException ex) {
        return ResponseEntity.badRequest().body(new GenericResponse<>("A database constraint was violated: " + ex.getMessage()));
    }
}
