package com.petproject1.daxi.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.NoSuchElementException;

import static com.petproject1.daxi.controller.exception.ErrorCode.INTERNAL;

public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
        return new ResponseEntity<>(responseBodyWithMessage(INTERNAL, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    private Map<ErrorCode, String> responseBodyWithMessage(ErrorCode code, String message) {
        return Map.of(code, message);
    }
}
