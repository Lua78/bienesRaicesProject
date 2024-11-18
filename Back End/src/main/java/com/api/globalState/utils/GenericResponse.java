package com.api.globalState.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class GenericResponse<T> {
    private T body;
    private String message;
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public GenericResponse(String message, HttpStatus httpStatus){
        this.message = message;
        this.status = httpStatus;
    }

    public GenericResponse(String message){
        this.message = message;
    }
}
