package com.api.globalState.utils.exceptions;

import com.api.globalState.utils.GenericResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseException.class)
    protected ResponseEntity<GenericResponse<String>> handleResponseException(ResponseException ex) {
        return ResponseEntity.badRequest().body(new GenericResponse<>(ex.getMessage()));
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<GenericResponse<String>> handleIntegrityException(DataIntegrityViolationException ex) {
        return ResponseEntity.badRequest().body(new GenericResponse<>("A database constraint was violated: " + ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<GenericResponse<Map<String, String>>> handleValidationsException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(new GenericResponse<>("Validation failed", errors));
    }
}
