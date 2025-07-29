package com.bakerx.bakerz.exceptions;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgymentNotValid(MethodArgumentNotValidException e){
        Map<String,String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach( err ->{
            String fieldName = ((FieldError)err).getField();
            String msg = err.getDefaultMessage();
            response.put(fieldName,msg);
        });
        return new ResponseEntity<Map<String, String>>(response,
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFound(ResourceNotFoundException e){
        String msg = e.getMessage();
        return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> APINotFound(APIException e){
        String msg = e.getMessage();
        return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex){
        ex.printStackTrace(); // Print the exact exception in logs
        return new ResponseEntity<>("Something went wrong: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
