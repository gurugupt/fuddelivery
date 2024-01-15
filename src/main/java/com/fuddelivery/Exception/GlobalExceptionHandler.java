package com.fuddelivery.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorMessage> usernotFound(UserNotFound ex)
    {
        Integer statusCode = HttpStatus.BAD_REQUEST.value();
        String message = ex.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(statusCode,message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);

    }


}
