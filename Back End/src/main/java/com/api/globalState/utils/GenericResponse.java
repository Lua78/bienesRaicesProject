package com.api.globalState.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class GenericResponse<T> {
    private T body;
    private List<String> messages;
    private Integer status = HttpStatus.BAD_REQUEST.value();

    public GenericResponse(String message, HttpStatus httpStatus){
        this.messages = List.of(message);
        this.status = httpStatus.value();
    }
    public GenericResponse(String message, T body){
        this.messages = List.of(message);
        this.body = body;
    }

    public GenericResponse(String message){
        this.messages = List.of(message);
    }
    public GenericResponse(List<String> messages){
        this.messages = messages;
    }
    public GenericResponse(List<String> messages, HttpStatus httpStatus){
        this.messages = messages;
        this.status = httpStatus.value();
    }
    public GenericResponse(List<String> messages, T body){
        this.messages = messages;
        this.body = body;
    }
    public GenericResponse(T body, String message, HttpStatus httpStatus){
        this.messages = List.of(message);
        this.body = body;
        this.status = httpStatus.value();
    }
}
