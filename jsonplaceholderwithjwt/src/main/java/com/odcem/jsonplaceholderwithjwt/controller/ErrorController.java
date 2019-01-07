package com.odcem.jsonplaceholderwithjwt.controller;

import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.exception.InvalidCredentialException;
import com.odcem.jsonplaceholderwithjwt.exception.InvalidParamException;
import com.odcem.jsonplaceholderwithjwt.exception.ParamNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = {ParamNotFoundException.class, InvalidCredentialException.class})
    public ResponseEntity<GenericDto<String>> handleMissingArgException(final RuntimeException ex){
        GenericDto<String> errorDto = new GenericDto<>(true, ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(value = {InvalidParamException.class})
    public ResponseEntity<GenericDto<String>> handleInvalidArgException(final RuntimeException ex){
        GenericDto<String> errorDto = new GenericDto<>(true, ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.OK);
    }
}