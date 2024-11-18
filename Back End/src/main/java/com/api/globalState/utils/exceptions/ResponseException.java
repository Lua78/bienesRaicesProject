package com.api.globalState.utils.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseException extends Exception {

    @Getter
    private HttpStatus code = HttpStatus.BAD_REQUEST;
    private String message;

    public ResponseException(String msg) {
        super(msg);
    }

    public ResponseException(String msg, HttpStatus code) {
        super(msg);
        this.code = code;
    }

}
