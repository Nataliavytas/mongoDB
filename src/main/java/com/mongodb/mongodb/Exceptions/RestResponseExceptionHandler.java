package com.mongodb.mongodb.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value
                = { ProductNotFoundException.class, NoSuchElementException.class})
        protected ResponseEntity<Object> handleProductNoTFound(
                RuntimeException ex, WebRequest request) {
            String bodyOfResponse = ex.getMessage();
            return handleExceptionInternal(ex, bodyOfResponse,
                    new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        }

    @ExceptionHandler(value
            = { NotEnoughStockException.class})
    protected ResponseEntity<Object> handleStockException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

