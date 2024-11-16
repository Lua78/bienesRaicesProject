package com.api.globalState.utils.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseException extends Exception {

    @Getter
    public HttpStatus code = HttpStatus.BAD_REQUEST;
    public List<String> messages;

    public ResponseException(String msg) {
        super(msg);
    }

    public ResponseException(String msg, HttpStatus code) {
        super(msg);
        this.code = code;
    }

    public List<String> getMessagesList() {
        return messages;
    }
}
