package com.bakerx.bakerz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class APIException extends  RuntimeException {
    public static final long serialVersionUID = 1L;
    public APIException(String message) {
        super(message);
    }
    public APIException() {
    }


}
