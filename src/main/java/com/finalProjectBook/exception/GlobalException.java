package com.finalProjectBook.exception;

import com.finalProjectBook.validation.NotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionObject> handleResourceNotFoundException(ResourceNotFoundException exception){
        ExceptionObject exceptionObject = new ExceptionObject();
        exceptionObject.setStatusCode(HttpStatus.NO_CONTENT.value());
        exceptionObject.setMessage(exception.getMessage());
        exceptionObject.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(exceptionObject, HttpStatus.NOT_FOUND);
    }

}
